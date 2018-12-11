package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.TextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.*;
import javax.swing.SwingConstants;

public class GameRoom extends JFrame {
	private JPanel contentPane;
	static JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6,
			textField_7, textField_8;
	static JTextArea messageArea;
	static JTextField textPane;

	static JPanel panel1;
	static JPanel panel2;
	static JPanel panel3;
	static JPanel panel4;
	static JPanel panel5;
	static JPanel panel6;
	static JPanel panel7;
	static JPanel panel8;
	static JPanel panel;
	static JPanel panel_1;
	static JPanel panel_2;
	static JPanel panel_3;
	static JPanel panel_4;
	static JPanel panel_5;
	static JPanel panel_6;
	static JPanel panel_7;
	static JPanel panel_8;
	static JPanel panel_9;
	static JPanel panel_10;
	static JPanel panel_11;
	static JPanel panel_12;
	static JPanel panel_13;
	static JPanel panel_14;
	static JPanel panel_15;
	static JPanel panel_16;
	static JPanel panel_17;
	static JPanel panel_18;
	static JPanel panel_19;
	static JPanel panel_20;
	static JPanel panel_21;
	static JPanel panel_22;
	static JPanel panel_23;
	static JPanel panel_24;
	static JPanel panel_25;
	static JPanel panel_26;
	static JPanel panel_27;
	static JPanel panel_28;
	static JPanel panel_29;
	static JPanel panel_30;
	static JPanel panel_31;
	static JFrame frame;
	static JPanel panel1_1;
	static JPanel panel2_1;
	static JPanel panel3_1;
	static JPanel panel4_1;
	static JPanel panel5_1;
	static JPanel panel6_1;
	static JPanel panel7_1;
	static JPanel panel8_1;
	static ImageIcon a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21,
			a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, clue1, clue2, clue3, clue4, clue5, clue6, clue7,
			clue8;
	static JTextField my_role;
	static JTextField mafia_check;
	static JPanel panel1_1_1;
	static JPanel panel2_1_1;
	static JPanel panel3_1_1;
	static JPanel panel4_1_1;
	static JPanel panel5_1_1;
	static JPanel panel6_1_1;
	static JPanel panel7_1_1;
	static JPanel panel8_1_1;
	static JTextField my_id;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GameRoom wait = new GameRoom();
		wait.frame.setVisible(true);
	}

	public GameRoom() {
		frame = new JFrame("Game room");
		ImageIcon user1 = new ImageIcon("Image/user1.png");
		ImageIcon user2 = new ImageIcon("Image/user2.png");
		ImageIcon user3 = new ImageIcon("Image/user3.png");
		ImageIcon user4 = new ImageIcon("Image/user4.png");
		ImageIcon user5 = new ImageIcon("Image/user5.png");
		ImageIcon user6 = new ImageIcon("Image/user6.png");
		ImageIcon user7 = new ImageIcon("Image/user7.png");
		ImageIcon user8 = new ImageIcon("Image/user8.png");
		ImageIcon title = new ImageIcon("Image/Waiting_room_title.png");
		ImageIcon death = new ImageIcon("Image/png/gameScreen/x.png");
		ImageIcon num = new ImageIcon("Image/png/gameScreen/1.png");
		ImageIcon back = new ImageIcon("Image/png/gameScreen/back.png");
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {

				Dimension d = getSize();
				g.drawImage(back.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				setOpaque(false);
				super.paintComponent(g);

			}
		};
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(1088, 709, 284, 34);
		contentPane.add(textField);
		textField.setHorizontalAlignment(textField.CENTER);

		messageArea = new JTextArea();
		messageArea.setFont(new Font("배달의민족주아체", Font.PLAIN, 15));
		messageArea.setBounds(1088, 42, 282, 666);
		contentPane.add(messageArea);
		messageArea.setEditable(false);

		panel1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user1.getImage(), 0, 0, 180, 130, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel1.setBounds(61, 239, 191, 143);
		contentPane.add(panel1);

		panel2 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user2.getImage(), 0, 0, 180, 130, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel2.setBounds(290, 239, 191, 143);
		contentPane.add(panel2);

		panel3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user3.getImage(), 0, 0, 180, 130, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel3.setBounds(529, 239, 191, 143);
		contentPane.add(panel3);

		panel4 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user4.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel4.setBounds(772, 239, 191, 143);
		contentPane.add(panel4);

		panel5 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user5.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel5.setBounds(61, 498, 191, 143);
		contentPane.add(panel5);

		panel6 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user6.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
		panel6.setBounds(290, 498, 191, 143);
		contentPane.add(panel6);

		panel7 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user7.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel7.setBounds(529, 498, 191, 143);
		contentPane.add(panel7);

		panel8 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user8.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel8.setBounds(772, 498, 191, 143);
		contentPane.add(panel8);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_1.setBounds(61, 197, 191, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setHorizontalAlignment(textField_1.CENTER);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_2.setBounds(290, 197, 191, 34);
		contentPane.add(textField_2);
		textField_2.setHorizontalAlignment(textField_2.CENTER);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_3.setBounds(529, 197, 191, 34);
		contentPane.add(textField_3);
		textField_3.setHorizontalAlignment(textField_3.CENTER);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_4.setBounds(772, 197, 191, 34);
		contentPane.add(textField_4);
		textField_4.setHorizontalAlignment(textField_4.CENTER);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_5.setBounds(61, 452, 191, 34);
		contentPane.add(textField_5);
		textField_5.setHorizontalAlignment(textField_5.CENTER);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_6.setBounds(290, 452, 191, 34);
		contentPane.add(textField_6);
		textField_6.setHorizontalAlignment(textField_6.CENTER);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_7.setBounds(529, 452, 191, 34);
		contentPane.add(textField_7);
		textField_7.setHorizontalAlignment(textField_7.CENTER);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_8.setBounds(772, 452, 191, 34);
		contentPane.add(textField_8);
		textField_8.setHorizontalAlignment(textField_8.CENTER);

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a1.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setBounds(60, 400, 40, 40);
		contentPane.add(panel);

		panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a2.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_1.setBounds(110, 400, 40, 40);
		contentPane.add(panel_1);

		panel_2 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a3.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_2.setBounds(160, 400, 40, 40);
		contentPane.add(panel_2);

		panel_3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a4.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_3.setBounds(212, 400, 40, 40);
		contentPane.add(panel_3);

		textPane = new JTextField();
		textPane.setFont(new Font("Gabriola", Font.BOLD, 50));
		textPane.setBounds(325, 30, 387, 101);
		contentPane.add(textPane);
		textPane.setColumns(10);
		textPane.setHorizontalAlignment(textPane.CENTER);

		panel_4 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a5.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_4.setBounds(441, 400, 40, 40);
		contentPane.add(panel_4);

		panel_5 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a6.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_5.setBounds(289, 400, 40, 40);
		contentPane.add(panel_5);

		panel_6 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a7.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_6.setBounds(339, 400, 40, 40);
		contentPane.add(panel_6);

		panel_7 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a8.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_7.setBounds(389, 400, 40, 40);
		contentPane.add(panel_7);

		panel_8 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a9.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_8.setBounds(680, 400, 40, 40);
		contentPane.add(panel_8);

		panel_9 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a10.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_9.setBounds(528, 400, 40, 40);
		contentPane.add(panel_9);

		panel_10 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a11.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_10.setBounds(578, 400, 40, 40);
		contentPane.add(panel_10);

		panel_11 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a12.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_11.setBounds(628, 400, 40, 40);
		contentPane.add(panel_11);

		panel_12 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a13.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_12.setBounds(923, 394, 40, 40);
		contentPane.add(panel_12);

		panel_13 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a14.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_13.setBounds(771, 394, 40, 40);
		contentPane.add(panel_13);

		panel_14 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a15.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_14.setBounds(821, 394, 40, 40);
		contentPane.add(panel_14);

		panel_15 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a16.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_15.setBounds(871, 394, 40, 40);
		contentPane.add(panel_15);

		panel_16 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a17.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_16.setBounds(212, 653, 40, 40);
		contentPane.add(panel_16);

		panel_17 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a18.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_17.setBounds(60, 653, 40, 40);
		contentPane.add(panel_17);

		panel_18 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a19.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_18.setBounds(110, 653, 40, 40);
		contentPane.add(panel_18);

		panel_19 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a20.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_19.setBounds(160, 653, 40, 40);
		contentPane.add(panel_19);

		panel_20 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a21.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_20.setBounds(441, 653, 40, 40);
		contentPane.add(panel_20);

		panel_21 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a22.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_21.setBounds(289, 653, 40, 40);
		contentPane.add(panel_21);

		panel_22 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a23.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_22.setBounds(339, 653, 40, 40);
		contentPane.add(panel_22);

		panel_23 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a24.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_23.setBounds(389, 653, 40, 40);
		contentPane.add(panel_23);

		panel_24 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a25.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_24.setBounds(681, 653, 40, 40);
		contentPane.add(panel_24);

		panel_25 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a26.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_25.setBounds(529, 653, 40, 40);
		contentPane.add(panel_25);

		panel_26 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a27.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_26.setBounds(579, 653, 40, 40);
		contentPane.add(panel_26);

		panel_27 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a28.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_27.setBounds(629, 653, 40, 40);
		contentPane.add(panel_27);

		panel_28 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a29.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_28.setBounds(923, 653, 40, 40);
		contentPane.add(panel_28);

		panel_29 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a30.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_29.setBounds(771, 653, 40, 40);
		contentPane.add(panel_29);

		panel_30 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a31.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_30.setBounds(821, 653, 40, 40);
		contentPane.add(panel_30);

		panel_31 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(a32.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_31.setBounds(871, 653, 40, 40);
		contentPane.add(panel_31);

		panel1_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel1_1.setBounds(0, 0, 191, 143);

		panel2_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel2_1.setBounds(0, 0, 191, 143);

		panel3_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel3_1.setBounds(0, 0, 191, 143);

		panel4_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel4_1.setBounds(0, 0, 191, 143);

		panel5_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel5_1.setBounds(0, 0, 191, 143);

		panel6_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel6_1.setBounds(0, 0, 191, 143);

		panel7_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel7_1.setBounds(0, 0, 191, 143);

		panel8_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel8_1.setBounds(0, 0, 191, 143);

		panel1_1.setVisible(false);
		panel2_1.setVisible(false);
		panel3_1.setVisible(false);
		panel4_1.setVisible(false);
		panel5_1.setVisible(false);
		panel6_1.setVisible(false);
		panel7_1.setVisible(false);
		panel8_1.setVisible(false);

		panel1.setLayout(null);

		panel1.add(panel1_1);
		panel2.setLayout(null);
		panel2.add(panel2_1);
		panel3.setLayout(null);
		panel3.add(panel3_1);
		panel4.setLayout(null);
		panel4.add(panel4_1);
		panel5.setLayout(null);
		panel5.add(panel5_1);
		panel6.setLayout(null);
		panel6.add(panel6_1);
		panel7.setLayout(null);
		panel7.add(panel7_1);
		panel8.setLayout(null);
		panel8.add(panel8_1);

		my_role = new JTextField();
		my_role.setFont(new Font("Gabriola", Font.BOLD, 30));
		my_role.setBounds(61, 11, 165, 57);
		my_role.setEditable(false);
		contentPane.add(my_role);
		my_role.setHorizontalAlignment(my_role.CENTER);

		mafia_check = new JTextField();
		mafia_check.setBounds(895, 32, 165, 105);
		contentPane.add(mafia_check);
		mafia_check.setColumns(10);
		mafia_check.setEditable(false);
		mafia_check.setHorizontalAlignment(mafia_check.CENTER);
		mafia_check.setVisible(false);

		panel1_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				{
					Dimension d = getSize();
					g.drawImage(clue1.getImage(), 0, 0, 40, 40, null);
					setOpaque(false);
					super.paintComponent(g);
				}
				;
			}
		};
		panel1_1_1.setBounds(132, 145, 40, 40);
		contentPane.add(panel1_1_1);
		panel1_1_1.setVisible(false);

		panel2_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(clue2.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel2_1_1.setBounds(363, 143, 40, 40);
		contentPane.add(panel2_1_1);
		panel2_1_1.setVisible(false);

		panel3_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(clue3.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel3_1_1.setBounds(609, 143, 40, 40);
		contentPane.add(panel3_1_1);
		panel3_1_1.setVisible(false);
		panel4_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(clue4.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel4_1_1.setBounds(849, 145, 40, 40);
		contentPane.add(panel4_1_1);
		panel4_1_1.setVisible(false);

		panel8_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(clue5.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel8_1_1.setVisible(false);
		panel8_1_1.setBounds(849, 709, 40, 40);
		contentPane.add(panel8_1_1);

		panel7_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(clue6.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel7_1_1.setBounds(609, 709, 40, 40);
		contentPane.add(panel7_1_1);
		panel7_1_1.setVisible(false);

		panel5_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(clue7.getImage(), 0, 0, 40, 40, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel5_1_1.setBounds(132, 709, 40, 40);
		contentPane.add(panel5_1_1);
		panel5_1_1.setVisible(false);

		panel6_1_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(clue8.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel6_1_1.setBounds(363, 709, 40, 40);
		contentPane.add(panel6_1_1);

		my_id = new JTextField();
		my_id.setHorizontalAlignment(SwingConstants.CENTER);
		my_id.setFont(new Font("Gabriola", Font.BOLD, 30));
		my_id.setEditable(false);
		my_id.setBounds(61, 80, 165, 57);
		contentPane.add(my_id);
		panel6_1_1.setVisible(false);

		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);
		panel6.setVisible(false);
		panel7.setVisible(false);
		panel8.setVisible(false);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.out2.println(textField.getText());
				textField.setText("");
			}
		});
		frame.setBounds(100, 50, 1400, 800);

		GameRoomThread runnable = new GameRoomThread();
		Thread Thread = new Thread(runnable);
		Thread.start();
	}
}