package Project;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;

public class GameRoomThread implements Runnable {
	int My_Role;
	int mafia_clue[] = new int[8];
	int init_count = 0;
	String array[] = new String[8];
	String clue_array[] = { " ", " ", " ", " ", " ", " ", " ", " ", " " };
	String id1, id2, id3, id4, id5, id6, id7, id8;
	int dead_man = 0;

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

				} else if (line.startsWith("[Clue]")) {
					clue_array = line.substring(7).split(" ");

					if (My_Role == 2) {
						if (GameRoom.textField_1.getText().equals(Login.user_id)) {
							int index = 0;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						} else if (GameRoom.textField_2.getText().equals(Login.user_id)) {
							int index = 5;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						} else if (GameRoom.textField_3.getText().equals(Login.user_id)) {
							int index = 9;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						} else if (GameRoom.textField_4.getText().equals(Login.user_id)) {
							int index = 13;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						} else if (GameRoom.textField_5.getText().equals(Login.user_id)) {
							int index = 17;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						} else if (GameRoom.textField_6.getText().equals(Login.user_id)) {
							int index = 21;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						} else if (GameRoom.textField_7.getText().equals(Login.user_id)) {
							int index = 25;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						} else if (GameRoom.textField_8.getText().equals(Login.user_id)) {
							int index = 29;
							Login.out.println("[MAFIA_CLUE]" + clue_array[index] + " " + clue_array[index + 1] + " "
									+ clue_array[index + 2] + " " + clue_array[index + 3]);

						}
					}
					String clue_image1 = "Image/µ¸º¸±â.png";
					String clue_image2 = "Image/½Ã°è.png";
					String clue_image3 = "Image/¾È°æ.png";
					String clue_image4 = "Image/¿¬ÇÊ.png";
					String clue_image5 = "Image/ÀÚ.png";
					String clue_image6 = "Image/ÃÑ.png";
					String clue_image7 = "Image/Ä®.png";
					String clue_image8 = "Image/Æ÷Å©.png";
					int index = 0;

					if (clue_array[index].equals("1"))
						GameRoom.a1 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a1 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a1 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a1 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a1 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a1 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a1 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a1 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a2 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a2 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a2 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a2 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a2 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a2 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a2 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a2 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a3 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a3 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a3 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a3 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a3 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a3 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a3 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a3 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a4 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a4 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a4 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a4 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a4 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a4 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a4 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a4 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a5 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a5 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a5 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a5 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a5 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a5 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a5 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a5 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a6 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a6 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a6 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a6 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a6 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a6 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a6 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a6 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a7 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a7 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a7 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a7 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a7 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a7 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a7 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a7 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a8 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a8 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a8 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a8 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a8 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a8 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a8 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a8 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a9 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a9 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a9 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a9 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a9 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a9 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a9 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a9 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a10 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a10 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a10 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a10 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a10 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a10 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a10 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a10 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a11 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a11 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a11 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a11 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a11 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a11 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a11 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a11 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a12 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a12 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a12 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a12 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a12 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a12 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a12 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a12 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a13 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a13 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a13 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a13 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a13 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a13 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a13 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a13 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a14 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a14 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a14 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a14 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a14 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a14 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a14 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a14 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a15 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a15 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a15 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a15 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a15 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a15 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a15 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a15 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a16 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a16 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a16 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a16 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a16 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a16 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a16 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a16 = new ImageIcon(clue_image8);
					index++;

					if (clue_array[index].equals("1"))
						GameRoom.a17 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a17 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a17 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a17 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a17 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a17 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a17 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a17 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a18 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a18 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a18 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a18 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a18 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a18 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a18 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a18 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a19 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a19 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a19 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a19 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a19 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a19 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a19 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a19 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a20 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a20 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a20 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a20 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a20 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a20 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a20 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a20 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a21 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a21 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a21 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a21 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a21 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a21 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a21 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a21 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a22 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a22 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a22 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a22 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a22 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a22 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a22 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a22 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a23 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a23 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a23 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a23 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a23 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a23 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a23 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a23 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a24 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a24 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a24 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a24 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a24 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a24 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a24 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a24 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a25 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a25 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a25 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a25 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a25 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a25 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a25 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a25 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a26 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a26 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a26 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a26 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a26 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a26 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a26 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a26 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a27 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a27 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a27 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a27 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a27 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a27 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a27 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a27 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a28 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a28 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a28 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a28 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a28 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a28 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a28 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a28 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a29 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a29 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a29 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a29 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a29 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a29 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a29 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a29 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a30 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a30 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a30 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a30 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a30 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a30 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a30 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a30 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a31 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a31 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a31 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a31 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a31 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a31 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a31 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a31 = new ImageIcon(clue_image8);
					index++;
					if (clue_array[index].equals("1"))
						GameRoom.a32 = new ImageIcon(clue_image1);
					else if (clue_array[index].equals("2"))
						GameRoom.a32 = new ImageIcon(clue_image2);
					else if (clue_array[index].equals("3"))
						GameRoom.a32 = new ImageIcon(clue_image3);
					else if (clue_array[index].equals("4"))
						GameRoom.a32 = new ImageIcon(clue_image4);
					else if (clue_array[index].equals("5"))
						GameRoom.a32 = new ImageIcon(clue_image5);
					else if (clue_array[index].equals("6"))
						GameRoom.a32 = new ImageIcon(clue_image6);
					else if (clue_array[index].equals("7"))
						GameRoom.a32 = new ImageIcon(clue_image7);
					else if (clue_array[index].equals("8"))
						GameRoom.a32 = new ImageIcon(clue_image8);
					index++;

					GameRoom.frame.setVisible(true);
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
					for (int i = 0; i < array.length; i++) {
						if (i == 1) {
							Voting.button.setText(array[i]);
							Voting.button.setVisible(true);
						}
						if (i == 2) {
							Voting.button_1.setText(array[i]);
							Voting.button_1.setVisible(true);
						}
						if (i == 3) {
							Voting.button_2.setText(array[i]);
							Voting.button_2.setVisible(true);
						}
						if (i == 4) {
							Voting.button_3.setText(array[i]);
							Voting.button_3.setVisible(true);
						}
						if (i == 5) {
							Voting.button_4.setText(array[i]);
							Voting.button_4.setVisible(true);
						}
						if (i == 6) {
							Voting.button_5.setText(array[i]);
							Voting.button_5.setVisible(true);
						}
						if (i == 7) {
							Voting.button_6.setText(array[i]);
							Voting.button_6.setVisible(true);
						}
						if (i == 8) {
							Voting.button_7.setText(array[i]);
							Voting.button_7.setVisible(true);
						}
					}

				} else if (line.startsWith("[Voting_id]")) {
					array = line.split(" ");
					for (String a : array)
						System.out.println("name : " + a);
				} else if (line.startsWith("[Mafia_Voting]")) {
					if (My_Role == 2) {
						new Voting_mafia();
						for (int i = 0; i < array.length; i++) {
							if (i == 1) {
								Voting_mafia.button.setText(array[i]);
								Voting_mafia.button.setVisible(true);
							}
							if (i == 2) {
								Voting_mafia.button_1.setText(array[i]);
								Voting_mafia.button_1.setVisible(true);
							}
							if (i == 3) {
								Voting_mafia.button_2.setText(array[i]);
								Voting_mafia.button_2.setVisible(true);
							}
							if (i == 4) {
								Voting_mafia.button_3.setText(array[i]);
								Voting_mafia.button_3.setVisible(true);
							}
							if (i == 5) {
								Voting_mafia.button_4.setText(array[i]);
								Voting_mafia.button_4.setVisible(true);
							}
							if (i == 6) {
								Voting_mafia.button_5.setText(array[i]);
								Voting_mafia.button_5.setVisible(true);
							}
							if (i == 7) {
								Voting_mafia.button_6.setText(array[i]);
								Voting_mafia.button_6.setVisible(true);
							}
							if (i == 8) {
								Voting_mafia.button_7.setText(array[i]);
								Voting_mafia.button_7.setVisible(true);
							}
						}
					} else {
						new vote_m().frame.setVisible(true);
					}
				} else if (line.startsWith("[Doctor_Voting]")) {
					vote_m.frame.setVisible(false);
					if (My_Role == 3) {
						new Voting_doctor();
						for (int i = 0; i < array.length; i++) {
							if (i == 1) {
								Voting_doctor.button.setText(array[i]);
								Voting_doctor.button.setVisible(true);
							}
							if (i == 2) {
								Voting_doctor.button_1.setText(array[i]);
								Voting_doctor.button_1.setVisible(true);
							}
							if (i == 3) {
								Voting_doctor.button_2.setText(array[i]);
								Voting_doctor.button_2.setVisible(true);
							}
							if (i == 4) {
								Voting_doctor.button_3.setText(array[i]);
								Voting_doctor.button_3.setVisible(true);
							}
							if (i == 5) {
								Voting_doctor.button_4.setText(array[i]);
								Voting_doctor.button_4.setVisible(true);
							}
							if (i == 6) {
								Voting_doctor.button_5.setText(array[i]);
								Voting_doctor.button_5.setVisible(true);
							}
							if (i == 7) {
								Voting_doctor.button_6.setText(array[i]);
								Voting_doctor.button_6.setVisible(true);
							}
							if (i == 8) {
								Voting_doctor.button_7.setText(array[i]);
								Voting_doctor.button_7.setVisible(true);
							}
						}

					} else if (My_Role == 2) {
						vote_m.frame.setVisible(false);
						Voting_mafia.frame.setVisible(false);
						new vote_d();
					} else {
						vote_m.frame.setVisible(false);
						new vote_d();
					}

				} else if (line.startsWith("[ShutDownResult]")) {
					if (dead_man == 1)
						dead_c.frame.setVisible(false);
					else if (dead_man == 2)
						dead_m.frame.setVisible(false);
					else if (dead_man == 3)
						dead_d.frame.setVisible(false);
					else if (dead_man == 4)
						dead_no_one.frame.setVisible(false);

				} else if (line.startsWith("[ShutDownVoting]")) {
					Voting.frame.setVisible(false);
				} else if (line.startsWith("[Reset]")) {
					if (My_Role == 3)
						Voting_doctor.frame.setVisible(false);
					else
						vote_d.frame.setVisible(false);
				} else if (line.startsWith("[Server Voting Result]")) {
					System.out.println("DEAD : " + line.substring(23));
					if (line.substring(23).startsWith("1")) {
						System.out.println("DEAD: " + line.substring(24));

						new dead_c().frame.setVisible(true);
						dead_man = 1;
					} else if (line.substring(23).startsWith("2")) {
						System.out.println("DEAD: " + line.substring(24));
						new dead_m().frame.setVisible(true);
						dead_man = 2;
					} else if (line.substring(23).startsWith("3")) {
						System.out.println("DEAD: " + line.substring(24));
						new dead_d().frame.setVisible(true);
						dead_man = 3;
					} else if (line.substring(23).startsWith("NO DEAD")) {
						System.out.println("DEAD: NO ONE");
						new dead_no_one().frame.setVisible(true);
						dead_man = 4;
					}
					if (GameRoom.textField_1.getText().equals(line.substring(24))) {
						GameRoom.panel1_1.setVisible(true);
					} else if (GameRoom.textField_2.getText().equals(line.substring(24))) {
						GameRoom.panel2_1.setVisible(true);
					} else if (GameRoom.textField_3.getText().equals(line.substring(24))) {
						GameRoom.panel3_1.setVisible(true);
					}
					else if (GameRoom.textField_4.getText().equals(line.substring(24))) {
						GameRoom.panel4_1.setVisible(true);
					}

					else if (GameRoom.textField_5.getText().equals(line.substring(24))) {
						GameRoom.panel5_1.setVisible(true);
					}

					else if (GameRoom.textField_6.getText().equals(line.substring(24))) {
						GameRoom.panel6_1.setVisible(true);
					}

					else if (GameRoom.textField_7.getText().equals(line.substring(24))) {
						GameRoom.panel7_1.setVisible(true);
					}

					else if (GameRoom.textField_8.getText().equals(line.substring(24))) {
						GameRoom.panel8_1.setVisible(true);
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
