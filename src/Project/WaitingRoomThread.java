package Project;

import java.io.IOException;
import java.net.UnknownHostException;

public class WaitingRoomThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				String line = Login.in.readLine();
				System.out.println(line);
				if (line.startsWith("SUBMITNAME")) {
					Login.out.println(Login.user_id);
				} else if (line.startsWith("NAMEACCEPTED")) {
					WaitingRoom.textField.setEditable(false);
					WaitingRoom.messageArea.setEditable(false);
				} else if (line.startsWith("ENTRANCE")) { // Entrance prototype
					if(WaitingRoom.textField_1.getText().length()<1) 
						WaitingRoom.textField_1.setText(line.substring(8));
					else if(WaitingRoom.textField_2.getText().length()<1) 
						WaitingRoom.textField_2.setText(line.substring(8));
					else if(WaitingRoom.textField_3.getText().length()<1) 
						WaitingRoom.textField_3.setText(line.substring(8));
					else if(WaitingRoom.textField_4.getText().length()<1) 
						WaitingRoom.textField_4.setText(line.substring(8));
					else if(WaitingRoom.textField_5.getText().length()<1) 
						WaitingRoom.textField_5.setText(line.substring(8));
					else if(WaitingRoom.textField_6.getText().length()<1) 
						WaitingRoom.textField_6.setText(line.substring(8));
					else if(WaitingRoom.textField_7.getText().length()<1) 
						WaitingRoom.textField_7.setText(line.substring(8));
					else if(WaitingRoom.textField_8.getText().length()<1) 
						WaitingRoom.textField_8.setText(line.substring(8));
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
