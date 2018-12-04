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
	private String url = "jdbc:mysql://localhost:8000/network?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=euc-kr";// user테이my블을
																																		// //
																																		// 수정하면
	private String strUser = "root"; // 계정 id
	private String strPassword = "12345"; // 계정 패스워드
	private String strMySQLDriver = "com.mysql.cj.jdbc.Driver"; // 드라이버 이름 따로 만들어줌
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
	int CHECK_FORCE = 0;
	static int voting[] = new int[8];
	static int mafia_voting[] = new int[8];
	static int doctor_voting[] = new int[8];
	// role = 1 -> 시민
	// role = 2 -> 마피아
	// role = 3 -> 의사
	static int role[] = new int[8];
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

						System.out.println("여기까진 돌아");
						String line = in.readLine();
						if (line.equals("Ready")) {
							user_ready_count++;
							System.out.println("user_ready_count =" + user_ready_count);
						} else if (line.equals("NotReady")) {
							user_ready_count--;
							System.out.println("user_ready_count =" + user_ready_count);
						}
						if (user_ready_count == 3) {
							for (PrintWriter writer : writers) {
								writer.println("[GameStart]");
							}
							for (String name1 : names) {
								set_id = set_id + " " + name1;
							}
							System.out.println("Server : " + set_id);
							user_ready_count = 0;
							TimerTask game_task = new TimerTask() {
								@Override
								public void run() {
									real_game_timer++;
									if (once_count == 0 && real_game_timer == 2) {
										for (PrintWriter writer : writers) {
											writer.println("[GameIsStart]");
										}
									} else if (once_count == 0 && real_game_timer == 5) {
										for (PrintWriter writer : writers) {
											writer.println("[WhatIsRole]");
										}
									} else if (real_game_timer == 10 && once_count == 0) {
										for (PrintWriter writer : writers) {
											writer.println("[TimerStart]");
										}
										once_count++;
									} else if (real_game_timer > 8 && real_game_timer < 28) {

										for (String name1 : names) {
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													map.get(name1).println("[Timer]" + (real_game_timer - 8));
												}
											}
										}
									} else if (real_game_timer == 28) {
										for (String name1 : names) {
											for (String dead1 : dead) {
												if (name1.equals(dead1)) {
													map.get(name1).println("[Voting_id]");
													map.get(name1).println("[Voting]");
												}
											}
										}
										for (PrintWriter writer : writers) {
											writer.println("[Voting_id] " + set_id);
											writer.println("[Voting]");
										}
									}
									// 투표 진행
									else if (real_game_timer > 28 && real_game_timer < 43) {

										for (PrintWriter writer : writers) {
											writer.println("[Timer]" + (real_game_timer - 28));
										}

									} else if (real_game_timer == 43) {
										for (PrintWriter writer : writers) {
											writer.println("[Mafia_Voting]");

										}
									} else if (real_game_timer > 43 && real_game_timer < 53) {
										for (PrintWriter writer : writers) {
											writer.println("[Timer]" + (real_game_timer - 43));
										}
									} else if (real_game_timer == 53) {
										for (PrintWriter writer : writers) {
											writer.println("[Doctor_Voting]");
										}
									} else if (real_game_timer > 53 && real_game_timer < 63) {
										for (PrintWriter writer : writers) {
											writer.println("[Timer]" + (real_game_timer - 53));
										}
									} else if (real_game_timer == 63) {
										for (PrintWriter writer : writers) {
											writer.println("[Reset]");
										}
										real_game_timer = 0;
									}
								}
							};
							Timer game_timer = new Timer();
							long delay = 0;
							long intevalPeriod = 1 * 1000;
							game_timer.scheduleAtFixedRate(game_task, delay, intevalPeriod);
						}
						System.out.println("Finish the waiting room");
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
							System.out.println("My Lotto " + random);
							if (random == 1 && citizen_count <= 6) {
								out.println("Take Role" + random);
								citizen_names.add(name);
								citizen_count++;

								break;
							} else if (random == 2 && mafia_count <= 2) {
								out.println("Take Role" + random);
								mafia_names.add(name);
								mafia_count++;
								break;
							} else if (random == 3 && doctor_count <= 1) {
								out.println("Take Role" + random);
								doctor_name.add(name);
								doctor_count++;
								break;
							}
						}
						out.println("Total_count" + citizen_count + " " + mafia_count + " " + doctor_count);
					} else if (Check_Class.startsWith("[Result]") == true) {
						int i = 0;
						// 값을 더해준다.
						for (String name1 : names) {
							if (name1.equals(Check_Class.substring(8)))
								voting[i]++;
							i++;
						}
						user_ready_count++;
						if (user_ready_count == 3) {
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
							// 동률일 경우에
							if (duplicate == 0)
								out.println("[Server Voting Result] NO DEAD");
							// 동률이 아닐경우에
							else {
								out.println("[Server Voting Result] " + temp_name);
								dead.add(temp_name);
							}
							for (i = 0; i < 8; i++) {
								voting[i] = 0;
							}
						}
					} else if (Check_Class.startsWith("[Mafia_Result]") == true) {
						int i = 0;
						// 값을 더해준다.
						for (String name1 : names) {
							if (name1.equals(Check_Class.substring(8)))
								voting[i]++;
							i++;
						}
						user_ready_count++;
						if (user_ready_count == 2) {
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
							// 동률일 경우에
							if (duplicate == 0)
								out.println("[Server Voting Result] NO DEAD");
							// 동률이 아닐경우에
							else {
								out.println("[Server Voting Result] " + temp_name);
								dead.add(temp_name);
							}

							for (i = 0; i < 8; i++) {
								voting[i] = 0;

							}
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
			// 로그인 버튼이 클릭 되었을시에 jdbc드라이버를 등록한다.
			Class.forName(strMySQLDriver);
			// DriverManager로부터 커넥션을 얻어오는데 mysql서버 . id, pw 등을 언어온다.
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			// 커넥션으로부터 실제로 sql쿼리 실행시키기 위한 statement 객체를 얻어온다.
			stmt = (Statement) con.createStatement();
			System.out.println("DB Connection Success");
		} catch (Exception b) {
			System.out.println("DB Connection Failed");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 해당하는 버튼값 가져오기
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
				System.out.println(rss + "번째 삽입");
				CHECK_FORCE = 1;
			} else {
				System.out.println("존재하는 아이디입니다");
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
		// SELECT 쿼리를 작성한다. 해당하는 아이디값의 패스워드를 검색한다.
		String query = "SELECT pw,name FROM user where id='" + id + "'";
		System.out.println(query);
		try {
			// executeQuery() 메서드로 SELECT문의 실행시키고 결과로 ResultSet 객체를 받는다.
			ResultSet rs = stmt.executeQuery(query);
			// 레코드가 있는지 검사
			if (rs.next()) {
				CHECK_FORCE = 0;
				name = rs.getString("name");
				// 텍스트필드에 쓴값과 데이터베이스에 있는 패스워드 값을 비교한다.
				if (pass.equals(rs.getString("pw"))) {
					System.out.println("일치한다");
					CHECK_FORCE = 1;
					// 맞으면 로그인서브를 띄워준다.
				} else {
					System.out.println("일치하지않는다");
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