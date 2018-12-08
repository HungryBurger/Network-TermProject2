package Project;

import java.io.IOException;
import java.net.UnknownHostException;

public class GameRoomThread implements Runnable {
	int My_Role;
	int clue_array[] = new int[32];
	int init_count = 0;
	String array[] = { " ", " ", " ", " ", " ", " ", " ", " ", " " };
	String id1, id2, id3, id4, id5, id6, id7, id8;
	int dead_man=0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Login.out.println("[GameRoom]" + Login.user_id);
			start.frame.setVisible(false);
			System.out.println("GameRoom Thread : " + Login.user_id);
			while (true) {
				String line = Login.in.readLine();
				System.out.println("GameRoom Thread : " + line);
				if (line.startsWith("[Timer]")) {
					GameRoom.textPane.setText(line.substring(7));
				} else if (line.startsWith("Take Role")) {
					My_Role = Integer.parseInt(line.substring(9));
				} else if (line.startsWith("[GameIsStart]")) {
					Login.out2.println("[GameStart]");
					new start().frame.setVisible(true);
				} else if (line.startsWith("[WhatIsRole]")) {
					start.frame.setVisible(false);
					if (My_Role == 1)
						new Im_citizen();
					else if (My_Role == 2)
						new Im_mafia();
					else if (My_Role == 3)
						new Im_doctor();

				} else if (line.startsWith("[TimerStart]")) {
					if (My_Role == 1)
						Im_citizen.frame.setVisible(false);
					else if (My_Role == 2)
						Im_mafia.frame.setVisible(false);
					else if (My_Role == 3)
						Im_doctor.frame.setVisible(false);
				}

				else if (line.startsWith("Total_count")) {
					System.out.println(line.substring(11));
				} else if (line.startsWith("[Voting]")) {
					new Voting();
					init_count = 1;
					if (array[1] != " ") {
						Voting.button.setText(array[1]);
						Voting.button.setVisible(true);
					}
					if (array[2] != " ") {
						Voting.button_1.setText(array[2]);
						Voting.button_1.setVisible(true);
					}
					/*
					 * if (array[3] != " ") { Voting.button_2.setText(array[3]);
					 * Voting.button_2.setVisible(true); } if (array[4] != " ") {
					 * Voting.button_3.setText(array[4]); Voting.button_3.setVisible(true); } if
					 * (array[5] != " ") { Voting.button_4.setText(array[5]);
					 * Voting.button_4.setVisible(true); } if (array[6] != " ") {
					 * Voting.button_5.setText(array[6]); Voting.button_5.setVisible(true); } if
					 * (array[7] != " ") { Voting.button_6.setText(array[7]);
					 * Voting.button_6.setVisible(true); } if (array[8] != " ") {
					 * Voting.button_7.setText(array[8]); Voting.button_7.setVisible(true); }
					 */

				} else if (line.startsWith("[Voting_id]")) {
					array = line.split(" ");
					for (String a : array)
						System.out.println("name : " + a);
				} else if (line.startsWith("[Mafia_Voting]")) {
					if (My_Role == 2) {
						new Voting_mafia();
						if (array[1] != " ") {
							Voting_mafia.button.setText(array[1]);
							Voting_mafia.button.setVisible(true);
						}
						if (array[2] != " ") {
							Voting_mafia.button_1.setText(array[2]);
							Voting_mafia.button_1.setVisible(true);
						} 
					} else {
						new vote_m().frame.setVisible(true);
					}
				} else if (line.startsWith("[Doctor_Voting]")) {
					vote_m.frame.setVisible(false);
					if (My_Role == 3) {
						new Voting_doctor();
						if (array[1] != " ") {
							Voting_doctor.button.setText(array[1]);
							Voting_doctor.button.setVisible(true);
						}
						if (array[2] != " ") {
							Voting_doctor.button_1.setText(array[2]);
							Voting_doctor.button_1.setVisible(true);
						}
						 
					} else if (My_Role == 2) {
						vote_m.frame.setVisible(false);
						Voting_mafia.frame.setVisible(false);
						new vote_d();
					} else {
						vote_m.frame.setVisible(false);
						new vote_d();
					}

				}else if (line.startsWith("[ShutDownResult]")) {
					if(dead_man==1)
						dead_c.frame.setVisible(false);
					else if(dead_man==2)
						dead_m.frame.setVisible(false);
					else if(dead_man==3)
						dead_d.frame.setVisible(false);
					else if(dead_man==4)
						dead_no_one.frame.setVisible(false);
					
						
				}
				else if (line.startsWith("[ShutDownVoting]")) {
					Voting.frame.setVisible(false);
				}
				else if (line.startsWith("[Reset]")) {
					if (My_Role == 3)
						Voting_doctor.frame.setVisible(false);
					else
						vote_d.frame.setVisible(false);
				} else if (line.startsWith("[Server Voting Result]")) {
					System.out.println("DEAD : " + line.substring(23));
					if (line.substring(23).startsWith("1")) {
						System.out.println("DEAD: " + line.substring(24));
						new dead_c().frame.setVisible(true);
						dead_man=1;
					} else if (line.substring(23).startsWith("2")) {
						System.out.println("DEAD: " + line.substring(24));
						new dead_m().frame.setVisible(true);
						dead_man=2;
					} else if (line.substring(23).startsWith("3")) {
						System.out.println("DEAD: " + line.substring(24));
						new dead_d().frame.setVisible(true);
						dead_man=3;
					}else if (line.substring(23).startsWith("NO DEAD")) {
						System.out.println("DEAD: NO ONE");
						new dead_no_one().frame.setVisible(true);
						dead_man=4;
					}
				} else if (line.startsWith("[MAFIA_WIN]")) {
					new MainMenu().setVisible(true);
					new win_m().frame.setVisible(true);
					GameRoom.frame.setVisible(false);
				} else if (line.startsWith("[CITIZEN_WIN]")) {
					new MainMenu().setVisible(true);
					new win_c().frame.setVisible(true);
					GameRoom.frame.setVisible(false);
				} else if (line.startsWith("[G_ENTRANCE]")) { // Entrance prototype
					if (GameRoom.textField_1.getText().length() < 1) {
						GameRoom.textField_1.setText(line.substring(12));
						GameRoom.panel1.setVisible(true);
					} else if (GameRoom.textField_2.getText().length() < 1) {
						GameRoom.textField_2.setText(line.substring(12));
						GameRoom.panel2.setVisible(true);
					} else if (GameRoom.textField_3.getText().length() < 1) {
						GameRoom.textField_3.setText(line.substring(12));
						GameRoom.panel3.setVisible(true);
					} else if (GameRoom.textField_4.getText().length() < 1) {
						GameRoom.textField_4.setText(line.substring(12));
						GameRoom.panel4.setVisible(true);
					} else if (GameRoom.textField_5.getText().length() < 1) {
						GameRoom.textField_5.setText(line.substring(12));
						GameRoom.panel5.setVisible(true);
					} else if (GameRoom.textField_6.getText().length() < 1) {
						GameRoom.textField_6.setText(line.substring(12));
						GameRoom.panel6.setVisible(true);
					} else if (GameRoom.textField_7.getText().length() < 1) {
						GameRoom.textField_7.setText(line.substring(12));
						GameRoom.panel7.setVisible(true);
					} else if (GameRoom.textField_8.getText().length() < 1) {
						GameRoom.textField_8.setText(line.substring(12));
						GameRoom.panel8.setVisible(true);
					} else
						System.out.println("ERROR wating thread");
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
