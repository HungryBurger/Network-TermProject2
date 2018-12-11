package Project;

import java.awt.*;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.*;
import javax.swing.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Server extends JFrame implements ActionListener {

	// jdbc set
	private String url = "jdbc:mysql://localhost:8000/network?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=euc-kr";// user����my����
																																		// //
																																		// �����ϸ�
	private String strUser = "root"; // ���� id
	private String strPassword = "12345"; // ���� �н�����
	private String strMySQLDriver = "com.mysql.cj.jdbc.Driver"; // ����̹� �̸� ���� �������
	private static final int PORT = 9001;
	static int real_game_timer = 0;
	// For socket Connection
	Connection con;
	Statement stmt;
	ResultSet rs;
	static int mafia_count = 0;
	static int doctor_count = 0;
	static int citizen_count = 0;
	static String set_id = "";
	String sql; // sql query
	String pass; // password
	String name; // name
	static int user_ready_count = 0;
	static int alive_user_count = 5;
	int CHECK_FORCE = 0;
	static int voting[] = new int[8];
	static int mafia_voting[] = new int[8];
	static int doctor_voting[] = new int[8];
	static int mafia_clue[] = new int[8];
	static int mafia_clue_index = 0;
	// role = 1 -> �ù�
	// role = 2 -> ���Ǿ�
	// role = 3 -> �ǻ�
	static int role[] = new int[8];
	static String clue_sentence = "";
	static int once_count = 0;
	public static HashSet<String> dead = new HashSet<String>();
	public static HashSet<String> names = new HashSet<String>();
	public static HashSet<String> mafia_names = new HashSet<String>();
	public static HashSet<String> doctor_name = new HashSet<String>();
	public static HashSet<String> citizen_names = new HashSet<String>();
	public static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	public static HashMap<String, PrintWriter> map = new HashMap<String, PrintWriter>();
	public static String every_user_id[];
	public static int user_id_sequence = 0;
	public static String mafia_result = "";
	// Call Login page
	Login log = new Login(); // true
	CreateAccount create = new CreateAccount();
	MainMenu menu = new MainMenu();

	// DB Connection
	private static class Handler extends Thread {
		private String Check_Class;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;
		private String name;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				while (true) {
					Check_Class = in.readLine();
					System.out.println(Check_Class);
					if (Check_Class.startsWith("[login]") == true) {
						String id = in.readLine();
						String pw = in.readLine();
						System.out.println(id);
						System.out.println(pw);

						String ch = new Server().MyInformation(id);
						System.out.println(ch);
						int temp = new Server().loginCheck(id, pw);
						if (temp == 1)
							out.println("Success");
						else
							out.println("Fail");

					} else if (Check_Class.startsWith("[CreateAccount]") == true) {

						String id = in.readLine();
						String pw = in.readLine();
						String name = in.readLine();
						String age = in.readLine();

						System.out.println(id);
						System.out.println(pw);
						System.out.println(name);
						System.out.println(age);
						int temp = new Server().selectInsert(id, pw, name, age);
						if (temp == 1)
							out.println("Success");
						else
							out.println("Fail");
					} else if (Check_Class.startsWith("[Ranking]") == true) {
						int i = 0;
						out.println("ranking");
						for (i = 0; i < 4; i++) {
							String ch = new Server().RANKOUT(i);
							String[] value = ch.split(" ");
							out.println(value[0]);
							out.println(value[1]);
							out.println(value[2]);
							System.out.println(value[0]);
							System.out.println(value[1]);
							System.out.println(value[2]);
						}
					} else if (Check_Class.startsWith("[Mypage]") == true) {
						out.println("mypage");
						String user_id = in.readLine();
						String ch = new Server().MyInformation(user_id);
						System.out.println(ch);
						String[] value = ch.split(" ");
						out.println(value[0]);
						out.println(value[1]);
						out.println(value[2]);
						out.println(value[3]);
						out.println(value[4]);
						out.println(value[5]);
						out.println(value[6]);
						out.println(value[7]);
					} else if (Check_Class.startsWith("[MypageUpdate]") == true) {
						String user_id = in.readLine();
						String user_pw = in.readLine();
						String user_name = in.readLine();
						String user_age = in.readLine();
						System.out.println(user_id);
						String ch = new Server().MyInformationUpdate(user_id, user_pw, user_name, user_age);
						out.println(ch);
					}

					else if (Check_Class.startsWith("[WaitingRoom]") == true) {
						while (true) {
							out.println("SUBMITNAME");
							name = in.readLine();
							if (name == null) {
								return;
							}
							synchronized (names) {
								if (!names.contains(name)) {
									names.add(name);
									break;
								}
							}
						}
						out.println("NAMEACCEPTED");
						writers.add(out);
						// Input the HasMap
						map.put(name, out);

						// Based users printing

						for (String name1 : names) {
							if (!name1.equals(name))
								out.println("ENTRANCE " + name1);
						}

						// Print to all users "Im in!!"
						for (PrintWriter writer : writers) {
							writer.println("ENTRANCE " + name);
						}
						String line = in.readLine();
						if (line.equals("Ready")) {
							user_ready_count++;
							System.out.println("user_ready_count =" + user_ready_count);
						} else if (line.equals("NotReady")) {
							user_ready_count--;
							System.out.println("user_ready_count =" + user_ready_count);
						}
						if (user_ready_count == 5) {
							for (PrintWriter writer : writers) {
								writer.println("[GameStart]");
							}
							for (String name1 : names) {
								set_id = set_id + " " + name1;
							}
							System.out.println("Server : " + set_id);
							user_ready_count = 0;
							Timer game_timer = new Timer();
							TimerTask game_task = new TimerTask() {
								@Override
								public void run() {
									real_game_timer++;
									if (once_count == 0 && real_game_timer == 2) {
										for (PrintWriter writer : writers) {
											writer.println("[GameIsStart]");
										}

									} else if (once_count == 0 && real_game_timer == 5) {

										for (String name1 : citizen_names)
											map.get(name1).println("[WhatIsRole]");
										for (String name1 : doctor_name)
											map.get(name1).println("[WhatIsRole]");

										for (String name1 : mafia_names) {
											if (mafia_count == 2) {
												for (String name2 : mafia_names) {
													if (!name1.equals(name2))
														map.get(name1).println("[WhatIsRole]" + name2);
												}
											} else {
												map.get(name1).println("[WhatIsRole]" + "NO");
											}
										}
										out.println(
												"Total_count" + citizen_count + " " + mafia_count + " " + doctor_count);

										int random2;
										for (int i = 0; i < 32; i++) {
											random2 = (int) (Math.random() * (8) + 1);
											clue_sentence += random2 + " ";
										}
										for (PrintWriter writer : writers) {
											writer.println("[Clue] " + clue_sentence);
										}

									} else if (real_game_timer == 10 && once_count == 0) {
										for (PrintWriter writer : writers) {
											writer.println("[TimerStart]");
										}
										once_count++;
									} else if (real_game_timer > 17 && real_game_timer < 25) {
										int check_dead = 0;
										for (String name1 : names) {
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													check_dead++;
												}
											}
											if (check_dead == 0) {
												map.get(name1).println("[Timer]" + (real_game_timer - 17));
											} else
												check_dead = 0;
										}
									} else if (real_game_timer == 27) {
										int check_dead = 0;
										String alive_set = " ";
										for (String name1 : names) {
											check_dead = 0;
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													check_dead++;
												}
											}
											if (check_dead == 0) {
												alive_set += name1 + " ";
											}
										}
										for (String name1 : names) {
											check_dead = 0;
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													check_dead++;
												}
											}
											if (check_dead == 0) {
												map.get(name1).println("[Voting_id]" + alive_set);
												map.get(name1).println("[Voting]");
											}
										}
									} else if (real_game_timer > 27 && real_game_timer < 50) {
										int check_dead = 0;
										for (String name1 : names) {
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													check_dead++;
												}
											}
											if (check_dead == 0) {
												map.get(name1).println("[Timer]" + (real_game_timer - 27));
											} else
												check_dead = 0;
										}
									} else if (real_game_timer == 50) {
										for (PrintWriter writer : writers) {
											writer.println("[ShutDownVoting]");
										}
									} else if (real_game_timer == 53) {
										for (PrintWriter writer : writers) {
											writer.println("[ShutDownResult]");
										}
										if (mafia_count == 0) {
											for (PrintWriter writer : writers) {
												writer.println("[CITIZEN_WIN]");
											}
											game_timer.cancel();
										} else if ((citizen_count + doctor_count) <= mafia_count) {
											for (PrintWriter writer : writers) {
												writer.println("[MAFIA_WIN]");
											}
											game_timer.cancel();
										}

									} else if (real_game_timer == 55) {
										int check_dead = 0;
										String alive_set = " ";
										for (String name1 : names) {
											check_dead = 0;
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													check_dead++;
												}
											}
											if (check_dead == 0) {
												alive_set += name1 + " ";
												System.out.println("ALIVE SET :" + name1);
											}
										}
										for (String name1 : names) {
											check_dead = 0;
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													check_dead++;
												}
											}
											if (check_dead == 0) {
												map.get(name1).println("[Mafia_Voting]" + alive_set);
												System.out.println("This is mafia_voting : " + alive_set);
											}
										}

									} else if (real_game_timer > 55 && real_game_timer < 65) {
										for (PrintWriter writer : writers) {
											writer.println("[Timer]" + (real_game_timer - 55));
										}
									} else if (real_game_timer == 65) {
										if (doctor_count == 0) {
											real_game_timer += 15;
										} else {
											int check_dead = 0;
											String alive_set = " ";
											for (String name1 : names) {
												check_dead = 0;
												for (String dead1 : dead) {
													if (name1.equals(dead1)) {
														check_dead++;
													}
												}
												if (check_dead == 0) {
													alive_set += name1 + " ";
												}
											}
											for (String name1 : names) {
												check_dead = 0;
												for (String dead1 : dead) {
													if (name1.equals(dead1)) {
														check_dead++;
													}
												}
												if (check_dead == 0) {
													map.get(name1).println("[Doctor_Voting]" + alive_set);
												}
											}
										}
									} else if (real_game_timer > 65 && real_game_timer < 75) {
										for (PrintWriter writer : writers) {
											writer.println("[Timer]" + (real_game_timer - 65));
										}
									} else if (real_game_timer == 75) {
										if (mafia_count == 0) {
											for (PrintWriter writer : writers) {
												writer.println("[CITIZEN_WIN]");
											}
										} else if (citizen_count <= mafia_count) {
											for (PrintWriter writer : writers) {
												writer.println("[MAFIA_WIN]");
											}
										}

										for (PrintWriter writer : writers) {
											writer.println("[Reset]");
										}
										real_game_timer = 17;
									}
								}
							};
							long delay = 0;
							long intevalPeriod = 1 * 1000;
							game_timer.scheduleAtFixedRate(game_task, delay, intevalPeriod);
						}
						System.out.println("Finish the waiting room");

					} else if (Check_Class.startsWith("[MAFIA_CLUE]") == true) {
						String str[] = Check_Class.substring(12).split(" ");

						mafia_clue[mafia_clue_index] = Integer.parseInt(str[0]);
						mafia_clue_index++;
						mafia_clue[mafia_clue_index] = Integer.parseInt(str[1]);
						mafia_clue_index++;
						mafia_clue[mafia_clue_index] = Integer.parseInt(str[2]);
						mafia_clue_index++;
						mafia_clue[mafia_clue_index] = Integer.parseInt(str[3]);
						mafia_clue_index++;

						for (int i = 0; i < mafia_clue.length; i++) {
							System.out.println("MAFIA_CLUE LIST =" + mafia_clue[i]);
						}

					} else if (Check_Class.startsWith("[GameRoom]") == true) {
						System.out.println("This is the Game Room");
						name = Check_Class.substring(10);
						for (PrintWriter writer : writers) {
							writer.println("[G_ENTRANCE]" + name);
						}
						int random;
						random = (int) (Math.random() * (3) + 1);
						while (true) {
							random = (int) (Math.random() * (3) + 1);
							if (random == 1 && citizen_count <= 5) {
								citizen_count++;
								if (citizen_count <= 5) {
									out.println("Take Role" + random);
									citizen_names.add(name);
									break;
								} else
									citizen_count--;
							} else if (random == 2 && mafia_count <= 2) {
								mafia_count++;
								if (mafia_count <= 2) {
									out.println("Take Role" + random);
									mafia_names.add(name);
									break;
								} else
									mafia_count--;
							} else if (random == 3 && doctor_count <= 1) {
								doctor_count++;
								if (doctor_count <= 1) {
									out.println("Take Role" + random);
									doctor_name.add(name);
									break;
								} else
									doctor_count--;
							}
						}
						System.out.println("My Lotto " + random);

					} else if (Check_Class.startsWith("[Result]") == true) {
						int i = 0;
						for (String name1 : names) {
							if (name1.equals(Check_Class.substring(8)))
								voting[i]++;
							i++;
						}
						user_ready_count++;
						if (user_ready_count == alive_user_count) {
							i = 0;
							int max = 0;
							String temp_name = "";
							int temp_index = 0;
							int duplicate = 0;
							for (String name1 : names) {
								if (i == 0) {
									max = voting[0];
									temp_name = name1;
									temp_index = 0;
								} else if (max < voting[i]) {
									max = voting[i];
									temp_name = name1;
									temp_index = i;
								}
								i++;
							}
							System.out.println(temp_name + " " + temp_index);
							for (String name1 : names) {
								if (temp_name.equals(name1)) {
									if (temp_index != i) {
										duplicate++;
									}
									System.out.println(name1 + duplicate);
								}
							}
							if (duplicate == 0)
								out.println("[Server Voting Result] NO DEAD");
							else {
								for (String a : citizen_names) {
									if (temp_name.equals(a)) {
										for (PrintWriter writer : writers) {
											writer.println("[Server Voting Result] " + "1" + temp_name);
										}
										citizen_count--;
										alive_user_count--;
									}
								}
								for (String a : mafia_names) {
									if (temp_name.equals(a)) {
										for (PrintWriter writer : writers) {
											writer.println("[Server Voting Result] " + "2" + temp_name);
										}
										mafia_count--;
										alive_user_count--;

									}
								}
								for (String a : doctor_name) {
									if (temp_name.equals(a)) {
										for (PrintWriter writer : writers) {
											writer.println("[Server Voting Result] " + "3" + temp_name);
										}
										doctor_count--;
										alive_user_count--;
									}
								}
								dead.add(temp_name);
							}
							for (i = 0; i < 8; i++) {
								voting[i] = 0;
							}
							user_ready_count = 0;
						}
					} else if (Check_Class.startsWith("[Mafia_Result]") == true) {
						int i = 0;
						for (String name1 : names) {
							if (name1.equals(Check_Class.substring(8)))
								voting[i]++;
							i++;
						}
						user_ready_count++;
						if (user_ready_count == mafia_count) {
							i = 0;
							int max = 0;
							String temp_name = "";
							int temp_index = 0;
							int duplicate = 0;
							for (String name1 : names) {
								if (i == 0) {
									max = voting[0];
									temp_name = name1;
									temp_index = 0;
								} else if (max < voting[i]) {
									max = voting[i];
									temp_name = name1;
									temp_index = i;
								}
								i++;
							}
							System.out.println(temp_name + " " + temp_index);
							for (String name1 : names) {
								if (temp_name.equals(name1)) {
									if (temp_index != i) {
										duplicate++;
									}
									System.out.println(name1 + duplicate);
								}
							}
							int random = (int) (Math.random() * (7));

							if (duplicate == 0)
								out.println("[ShutDownMD] NO DEAD");
							else {
								if (doctor_count == 0) {

									for (String a : citizen_names) {
										if (temp_name.equals(a)) {
											for (PrintWriter writer : writers) {
												writer.println("[ShutDownMD] " + "1" + temp_name);
												writer.println("[ShowMafiaClue] " + mafia_clue[random] + temp_name);
											}
											citizen_count--;
											alive_user_count--;
										}
									}
									for (String a : mafia_names) {
										if (temp_name.equals(a)) {
											for (PrintWriter writer : writers) {
												writer.println("[ShutDownMD] " + "2" + temp_name);
												writer.println("[ShowMafiaClue] " + mafia_clue[random] + temp_name);
											}
											mafia_count--;
											alive_user_count--;

										}
									}
									for (String a : doctor_name) {
										if (temp_name.equals(a)) {
											for (PrintWriter writer : writers) {
												writer.println("[ShutDownMD] " + "3" + temp_name);
												writer.println("[ShowMafiaClue] " + mafia_clue[random] + temp_name);
											}
											doctor_count--;
											alive_user_count--;
										}
									}
									dead.add(temp_name);
								}
								for (i = 0; i < 8; i++) {
									voting[i] = 0;
								}
								user_ready_count = 0;
							}
						}

					} else if (Check_Class.startsWith("[Doctor_Result]") == true) {
						int i = 0;
						for (String name1 : names) {
							if (name1.equals(Check_Class.substring(8)))
								voting[i]++;
							i++;
						}
						user_ready_count++;
						if (user_ready_count == doctor_count) {
							i = 0;
							int max = 0;
							String temp_name = "";
							int temp_index = 0;
							int duplicate = 0;
							for (String name1 : names) {
								if (i == 0) {
									max = voting[0];
									temp_name = name1;
									temp_index = 0;
								} else if (max < voting[i]) {
									max = voting[i];
									temp_name = name1;
									temp_index = i;
								}
								i++;
							}
							System.out.println(temp_name + " " + temp_index);
							for (String name1 : names) {
								if (temp_name.equals(name1)) {
									if (temp_index != i && voting[temp_index] != 0) {
										duplicate++;
									}
									System.out.println("값이 동률이 있다" + name1 + duplicate);
								}
							}
							int random = (int) (Math.random() * (7));
							if (temp_name.equals(mafia_result)) {
								out.println("[ShutDownMD] NO DEAD");

							} else {
								for (String a : citizen_names) {
									if (temp_name.equals(a)) {
										for (PrintWriter writer : writers) {
											writer.println("[ShutDownMD] " + "1" + temp_name);
											writer.println("[ShowMafiaClue] " + mafia_clue[random] + temp_name);
										}
										citizen_count--;
										alive_user_count--;
									}
								}
								for (String a : mafia_names) {
									if (temp_name.equals(a)) {
										for (PrintWriter writer : writers) {
											writer.println("[ShutDownMD] " + "2" + temp_name);
											writer.println("[ShowMafiaClue] " + mafia_clue[random] + temp_name);
										}
										mafia_count--;
										alive_user_count--;

									}
								}
								for (String a : doctor_name) {
									if (temp_name.equals(a)) {
										for (PrintWriter writer : writers) {
											writer.println("[ShutDownMD] " + "3" + temp_name);
											writer.println("[ShowMafiaClue] " + mafia_clue[random] + temp_name);
										}
										doctor_count--;
										alive_user_count--;
									}
								}
								dead.add(temp_name);
							}
							for (i = 0; i < 8; i++) {
								voting[i] = 0;
							}
							user_ready_count = 0;
						}
					}
				}

			} catch (

			IOException e) {
				System.out.println(e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}

	}

	public Server() {
		try {
			Class.forName(strMySQLDriver);
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			stmt = (Statement) con.createStatement();
			System.out.println("DB Connection Success");
		} catch (Exception b) {
			System.out.println("DB Connection Failed");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
	}

	// Add user
	int selectInsert(String id, String pw, String name, String age) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.id = id;
		d.pw = pw;
		d.name = name;
		d.age = age;
		System.out.println(id + pw + name + age);
		String sql = "insert into user value('" + d.id + "','" + d.pw + "','" + d.name + "'," + Integer.parseInt(d.age)
				+ ",0,0,0,0)";
		String sql2 = "SELECT pw,name FROM user where id='" + id + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql2);
			System.out.println(sql2);
			CHECK_FORCE = 0;
			if (!rs.next()) {
				int rss = stmt.executeUpdate(sql);
				System.out.println(rss + "��° ����");
				CHECK_FORCE = 1;
			} else {
				System.out.println("�����ϴ� ���̵��Դϴ�");
				CHECK_FORCE = 0;
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println(CHECK_FORCE);
		return CHECK_FORCE;
	}

	// Check login
	int loginCheck(String id, String pass) {
		// SELECT ������ �ۼ��Ѵ�. �ش��ϴ� ���̵��� �н����带 �˻��Ѵ�.
		String query = "SELECT pw,name FROM user where id='" + id + "'";
		System.out.println(query);
		try {
			// executeQuery() �޼���� SELECT���� �����Ű�� ����� ResultSet ��ü�� �޴´�.
			ResultSet rs = stmt.executeQuery(query);
			// ���ڵ尡 �ִ��� �˻�
			if (rs.next()) {
				CHECK_FORCE = 0;
				name = rs.getString("name");
				// �ؽ�Ʈ�ʵ忡 ������ �����ͺ��̽��� �ִ� �н����� ���� ���Ѵ�.
				if (pass.equals(rs.getString("pw"))) {
					System.out.println("��ġ�Ѵ�");
					CHECK_FORCE = 1;
					// ������ �α��μ��긦 ����ش�.
				} else {
					System.out.println("��ġ�����ʴ´�");
					CHECK_FORCE = 0;
				}
			} else {
				System.out.println("doesn't exist");
			}
		} catch (Exception b) {
			b.printStackTrace();
		}
		return CHECK_FORCE;
	}

	String RANKOUT(int num) {
		String str = "";
		String Rank_id = "";
		String Rank_score = "";
		String Rank_victory = "";
		String sql1 = "select id, victory, score from user order by score desc limit " + num + ",1";
		try {
			ResultSet rs = stmt.executeQuery(sql1);
			System.out.println(sql1);
			System.out.println(rs.next());
			Rank_id = new String(rs.getString("id"));
			Rank_score = new String(rs.getString("score"));
			Rank_victory = new String(rs.getString("victory"));

			System.out.println(Rank_id);
			System.out.println(Rank_score);
			System.out.println(Rank_victory);
			String sql2 = "UPDATE user set Ranking = '" + (num + 1) + "'where id = '" + Rank_id + "'";
			System.out.println(sql2);
			int rt = stmt.executeUpdate(sql2);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return Rank_id + " " + Rank_score + " " + Rank_victory;
	}

	String MyInformation(String user_id) {
		String Rank_id = "";
		String Rank_score = "";
		String Rank_victory = "";
		String Rank_name = "";
		String Rank_pw = "";
		String Rank_age = "";
		String Rank_lose = "";
		String Rank_ranking = "";
		String sql1 = "select * from user where id = '" + user_id + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql1);
			System.out.println(sql1);
			System.out.println(rs.next());
			Rank_id = new String(rs.getString("id"));
			Rank_pw = new String(rs.getString("pw"));
			Rank_name = new String(rs.getString("name"));
			Rank_age = new String(rs.getString("age"));
			Rank_score = new String(rs.getString("score"));
			Rank_ranking = new String(rs.getString("ranking"));
			Rank_victory = new String(rs.getString("victory"));
			Rank_lose = new String(rs.getString("lose"));

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return Rank_id + " " + Rank_pw + " " + Rank_name + " " + Rank_age + " " + Rank_score + " " + Rank_ranking + " "
				+ Rank_victory + " " + Rank_lose;
	}

	String MyInformationUpdate(String user_id, String user_pw, String user_name, String user_age) {
		String sql1 = "UPDATE user set pw = '" + user_pw + "'where id = '" + user_id + "'";
		String sql2 = "UPDATE user set name = '" + user_name + "'where id = '" + user_id + "'";
		String sql3 = "UPDATE user set age = '" + user_age + "'where id = '" + user_id + "'";

		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);

		try {
			int rt = stmt.executeUpdate(sql1);
			int rt2 = stmt.executeUpdate(sql2);
			int rt3 = stmt.executeUpdate(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public static void main(String[] args) throws Exception {
		System.out.println("The Server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Server();
				new Handler(listener.accept()).start();
			}
		} finally {
			listener.close();
		}
	}
}