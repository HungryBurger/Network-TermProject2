package Project;

import java.io.IOException;
import java.net.UnknownHostException;

public class ChatThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				// Read line from server
				String line = Login.in2.readLine();
				
				System.out.println(line);
				if (line.startsWith("SUBMITNAME")) {
					Login.out2.println(Login.user_id); 
				} else if (line.startsWith("NAMEACCEPTED")) {
					WaitingRoom.textField.setEditable(true);
					WaitingRoom.messageArea.setEditable(false);
				} else if (line.startsWith("FIRST")) {
					WaitingRoom.messageArea.append(line.substring(5) + "\n");
				} else if (line.startsWith("MESSAGE")) {
					WaitingRoom.messageArea.append(line.substring(8) + "\n");
				} else if (line.startsWith("ENTRANCE")) { // Entrance prototype
					WaitingRoom.messageArea.append(line.substring(9) + "\n");
				} else if (line.startsWith("EXIT")) { // Exit prototype
					WaitingRoom.messageArea.append(line.substring(5) + "\n");
				} else if (line.startsWith("WHISPER")) { // whisper prototype
					WaitingRoom.messageArea.append(line.substring(8) + "\n");
				} else if (line.startsWith("G_First")) {
					GameRoom.messageArea.append(line.substring(7) + "\n");
				} else if (line.startsWith("G_ENTRANCE")) { // Entrance prototype
					GameRoom.messageArea.append(line.substring(10) + "\n");
				} else if (line.startsWith("G_MESSAGE")) {
					GameRoom.messageArea.append(line.substring(10) + "\n");
				} else if (line.startsWith("G_WHISPER")) {
					GameRoom.messageArea.append(line.substring(10) + "\n");
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
