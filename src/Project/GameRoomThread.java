package Project;

import java.io.IOException;
import java.net.UnknownHostException;

public class GameRoomThread implements Runnable {
	int My_Role;
	int init_count = 0;
	String id1, id2, id3, id4, id5, id6, id7, id8;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Login.out.println("[GameRoom]");
			Login.out2.println("[GameRoom]");
			Login.out.println(Login.user_id);
			System.out.println("GameRoom Thread : " + Login.user_id);
			while (true) {
				String line = Login.in.readLine();
				System.out.println("GameRoom Thread : " + line);
				if (line.startsWith("[Timer]")) {
					GameRoom.textPane.setText(line.substring(7));
				} else if (line.startsWith("Take Role")) {
					System.out.println(line.substring(9));
					My_Role = Integer.parseInt(line.substring(9));

				} else if (line.startsWith("Total_count")) {
					System.out.println(line.substring(11));
				} else if (line.startsWith("[Voting]")) {
					new Voting();
					init_count = 1;
					Voting.button.setText(id1);
					Voting.button_1.setText(id2);
					Voting.button_2.setText(id3);
					Voting.button_3.setText(id4);
					Voting.button_4.setText(id5);
					Voting.button_5.setText(id6);
					Voting.button_6.setText(id7);
					Voting.button_7.setText(id8);

				} else if (line.startsWith("[Voting_id]")) {
					id1 = line.split(" ")[0];
					id1 = line.split(" ")[0];
					id2 = line.split(" ")[0];
					id3 = line.split(" ")[0];
					id4 = line.split(" ")[0];
					id5 = line.split(" ")[0];
					id6 = line.split(" ")[0];
					id7 = line.split(" ")[0];
					id8 = line.split(" ")[0];
				} else if (line.startsWith("[Mafia_voting]")) {
					Voting.frame.setVisible(false);
				} else if (line.startsWith("[Doctor_voting]")) {

				} else if (line.startsWith("Give Role")) {

				} else if (line.startsWith("G_ENTRANCE")) { // Entrance prototype
					if (GameRoom.textField_1.getText().length() < 1) {
						GameRoom.textField_1.setText(line.substring(11));
						GameRoom.panel1.setVisible(true);
					} else if (GameRoom.textField_2.getText().length() < 1) {
						GameRoom.textField_2.setText(line.substring(11));
						GameRoom.panel2.setVisible(true);
					} else if (GameRoom.textField_3.getText().length() < 1) {
						GameRoom.textField_3.setText(line.substring(11));
						GameRoom.panel3.setVisible(true);
					} else if (GameRoom.textField_4.getText().length() < 1) {
						GameRoom.textField_4.setText(line.substring(11));
						GameRoom.panel4.setVisible(true);
					} else if (GameRoom.textField_5.getText().length() < 1) {
						GameRoom.textField_5.setText(line.substring(11));
						GameRoom.panel5.setVisible(true);
					} else if (GameRoom.textField_6.getText().length() < 1) {
						GameRoom.textField_6.setText(line.substring(11));
						GameRoom.panel6.setVisible(true);
					} else if (GameRoom.textField_7.getText().length() < 1) {
						GameRoom.textField_7.setText(line.substring(11));
						GameRoom.panel7.setVisible(true);
					} else if (GameRoom.textField_8.getText().length() < 1) {
						GameRoom.textField_8.setText(line.substring(11));
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
