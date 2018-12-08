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


public class GameRoom extends JFrame {
	private JPanel contentPane;
	static JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8;
	static JTextArea messageArea;
	static JTextPane textPane;
	static JPanel panel1;
	static JPanel panel2;
	static JPanel panel3;
	static JPanel panel4;
	static JPanel panel5;
	static JPanel panel6;
	static JPanel panel7;
	static JPanel panel8;
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
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GameRoom wait = new GameRoom();
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
			public void paintComponent(Graphics g)
			{
				
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

		messageArea = new JTextArea();
		messageArea.setFont(new Font("±¼¸²", Font.PLAIN, 15));
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_2.setBounds(290, 197, 191, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_3.setBounds(529, 197, 191, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_4.setBounds(772, 197, 191, 34);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_5.setBounds(61, 452, 191, 34);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_6.setBounds(290, 452, 191, 34);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_7.setBounds(529, 452, 191, 34);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_8.setBounds(772, 452, 191, 34);
		contentPane.add(textField_8);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 400, 40, 40);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(110, 400, 40, 40);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(160, 400, 40, 40);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(212, 400, 40, 40);
		contentPane.add(panel_3);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Gabriola", Font.BOLD, 50));
		textPane.setBounds(325, 30, 387, 101);
		contentPane.add(textPane);
		
		panel_4 = new JPanel();
		panel_4.setBounds(441, 400, 40, 40);
		contentPane.add(panel_4);
		
		panel_5 = new JPanel();
		panel_5.setBounds(289, 400, 40, 40);
		contentPane.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setBounds(339, 400, 40, 40);
		contentPane.add(panel_6);
		
		panel_7 = new JPanel();
		panel_7.setBounds(389, 400, 40, 40);
		contentPane.add(panel_7);
		
		panel_8 = new JPanel();
		panel_8.setBounds(680, 400, 40, 40);
		contentPane.add(panel_8);
		
		panel_9 = new JPanel();
		panel_9.setBounds(528, 400, 40, 40);
		contentPane.add(panel_9);
		
		panel_10 = new JPanel();
		panel_10.setBounds(578, 400, 40, 40);
		contentPane.add(panel_10);
		
		panel_11 = new JPanel();
		panel_11.setBounds(628, 400, 40, 40);
		contentPane.add(panel_11);
		
		panel_12 = new JPanel();
		panel_12.setBounds(923, 394, 40, 40);
		contentPane.add(panel_12);
		
		panel_13 = new JPanel();
		panel_13.setBounds(771, 394, 40, 40);
		contentPane.add(panel_13);
		
		panel_14 = new JPanel();
		panel_14.setBounds(821, 394, 40, 40);
		contentPane.add(panel_14);
		
		panel_15 = new JPanel();
		panel_15.setBounds(871, 394, 40, 40);
		contentPane.add(panel_15);
		
		panel_16 = new JPanel();
		panel_16.setBounds(212, 653, 40, 40);
		contentPane.add(panel_16);
		
		panel_17 = new JPanel();
		panel_17.setBounds(60, 653, 40, 40);
		contentPane.add(panel_17);
		
		panel_18 = new JPanel();
		panel_18.setBounds(110, 653, 40, 40);
		contentPane.add(panel_18);
		
		panel_19 = new JPanel();
		panel_19.setBounds(160, 653, 40, 40);
		contentPane.add(panel_19);
		
		panel_20 = new JPanel();
		panel_20.setBounds(441, 653, 40, 40);
		contentPane.add(panel_20);
		
		panel_21 = new JPanel();
		panel_21.setBounds(289, 653, 40, 40);
		contentPane.add(panel_21);
		
		panel_22 = new JPanel();
		panel_22.setBounds(339, 653, 40, 40);
		contentPane.add(panel_22);
		
		panel_23 = new JPanel();
		panel_23.setBounds(389, 653, 40, 40);
		contentPane.add(panel_23);
		
		panel_24 = new JPanel();
		panel_24.setBounds(681, 653, 40, 40);
		contentPane.add(panel_24);
		
		panel_25 = new JPanel();
		panel_25.setBounds(529, 653, 40, 40);
		contentPane.add(panel_25);
		
		panel_26 = new JPanel();
		panel_26.setBounds(579, 653, 40, 40);
		contentPane.add(panel_26);
		
		panel_27 = new JPanel();
		panel_27.setBounds(629, 653, 40, 40);
		contentPane.add(panel_27);
		
		panel_28 = new JPanel();
		panel_28.setBounds(923, 653, 40, 40);
		contentPane.add(panel_28);
		
		panel_29 = new JPanel();
		panel_29.setBounds(771, 653, 40, 40);
		contentPane.add(panel_29);
		
		panel_30 = new JPanel();
		panel_30.setBounds(821, 653, 40, 40);
		contentPane.add(panel_30);
		
		panel_31 = new JPanel();
		panel_31.setBounds(871, 653, 40, 40);
		contentPane.add(panel_31);
		/*
		 * ButtonGroup grp = new ButtonGroup(); JRadioButton[] rb = new JRadioButton[8];
		 * for (int i = 0; i < 8; i++) grp.add(rb[i]); rb[0] = new
		 * JRadioButton("User1"); rb[0].setBounds(50, 515, 100, 27);
		 * contentPane.add(rb[0]);
		 * 
		 * rb[1] = new JRadioButton("User2"); rb[1].setBounds(150, 515, 100, 27);
		 * contentPane.add(rb[1]);
		 * 
		 * rb[2] = new JRadioButton("User3"); rb[2].setBounds(50, 565, 100, 27);
		 * contentPane.add(rb[2]);
		 * 
		 * rb[3] = new JRadioButton("User4"); rb[3].setBounds(150, 565, 100, 27);
		 * contentPane.add(rb[3]);
		 * 
		 * rb[4] = new JRadioButton("User5"); rb[4].setBounds(50, 615, 100, 27);
		 * contentPane.add(rb[4]);
		 * 
		 * rb[5] = new JRadioButton("User6"); rb[5].setBounds(150, 615, 100, 27);
		 * contentPane.add(rb[5]);
		 * 
		 * rb[6] = new JRadioButton("User7"); rb[6].setBounds(50, 665, 100, 27);
		 * contentPane.add(rb[6]);
		 * 
		 * rb[7] = new JRadioButton("User8"); rb[7].setBounds(150, 665, 100, 27);
		 * contentPane.add(rb[7]);
		 * 
		 * JButton btnNewButton_1 = new JButton("È®ÀÎ"); btnNewButton_1.setBounds(14, 709,
		 * 248, 34); contentPane.add(btnNewButton_1);
		 * 
		 * for (JRadioButton c : rb) { grp.add(c); contentPane.add(c); }
		 */
		
		panel1_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel1_1.setBounds(0, 0, 200, 140);
		
		panel2_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel2_1.setBounds(0, 0, 200, 140);
		
		panel3_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel3_1.setBounds(0, 0, 200, 140);
		
		panel4_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel4_1.setBounds(0, 0, 200, 140);
		
		panel5_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel5_1.setBounds(0, 0, 200, 140);
		
		panel6_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel6_1.setBounds(0, 0,200, 140);
		
		panel7_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel7_1.setBounds(0, 0, 200, 140);
		
		panel8_1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(death.getImage(), 0, 0, 191, 143, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel8_1.setBounds(0, 0, 200, 140);
		
		
		
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
		frame.setVisible(true);
		
		GameRoomThread runnable = new GameRoomThread();
		Thread Thread = new Thread(runnable);
		Thread.start();
	}
}