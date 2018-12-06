package Project;

import java.io.IOException;
import java.net.UnknownHostException;

public class GameRoomThread implements Runnable {
	int My_Role;
	int init_count = 0;
	String[] array;
	String id1, id2, id3, id4, id5, id6, id7, id8;

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
					Voting.button.setText(array[2]);
					Voting.button_1.setText(array[3]);
					Voting.button_2.setText(array[4]);
					/*
					 * Voting.button_3.setText(array[5]); Voting.button_4.setText(array[6]);
					 * Voting.button_5.setText(array[7]); Voting.button_6.setText(array[8]);
					 * Voting.button_7.setText(array[9]);
					 */
					/*
					 * Voting.button_2.setText(array[3]); Voting.button_3.setText(array[4]);
					 * Voting.button_4.setText(array[5]); Voting.button_5.setText(array[6]);
					 * Voting.button_6.setText(array[7]); Voting.button_7.setText(array[8]);
					 */
					
				} else if (line.startsWith("[Voting_id]")) {
					array = line.split(" ");
				} else if (line.startsWith("[Mafia_Voting]")) {
					Voting.frame.setVisible(false);
					if (My_Role == 2) {
						new Voting_mafia();
						Voting_mafia.button.setText(array[2]);
						Voting_mafia.button_1.setText(array[3]);
						Voting_mafia.button_2.setText(array[4]);
					} else {
						new vote_m().frame.setVisible(true);
					}
					/*
					 * Voting.button_3.setText(array[5]); Voting.button_4.setText(array[6]);
					 * Voting.button_5.setText(array[7]); Voting.button_6.setText(array[8]);
					 * Voting.button_7.setText(array[9]);
					 */
				} else if (line.startsWith("[Doctor_Voting]")) {
					vote_m.frame.setVisible(false);
					if (My_Role == 3) {
						new Voting_doctor();
						Voting_mafia.button.setText(array[2]);
						Voting_mafia.button_1.setText(array[3]);
						Voting.button_2.setText(array[4]);
					} else if (My_Role == 2) {
						vote_m.frame.setVisible(false);
						Voting_mafia.frame.setVisible(false);
						new vote_d();
					} else {
						vote_m.frame.setVisible(false);
						new vote_d();
					} 

				} else if (line.startsWith("[Reset]")) {
					if (My_Role == 3)
						Voting_doctor.frame.setVisible(false);
					else
						vote_d.frame.setVisible(false);

				} else if (line.startsWith("[Server Voting Result]")) {
					System.out.println(line.substring(23));
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
