package Project;

import java.io.IOException;
import java.net.UnknownHostException;

public class GameRoomThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Login.out.println("[GameRoom]");
			Login.out2.println("[GameRoom]");
			while (true) {
				String line = Login.in.readLine();
				System.out.println("GameRoom Thread : " + line);
				if (line.startsWith("Timer")) {
					GameRoom.textPane.setText(line.substring(5));
				} else if (line.startsWith("Take Role")) {
					System.out.println(line.substring(9));
				} else if (line.startsWith("Total_count")) {
					System.out.println(line.substring(11));
				} else if (line.startsWith("Citizen_voting")) {

				} else if (line.startsWith("Give Role")) {
					String hello = Login.in.readLine();
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
