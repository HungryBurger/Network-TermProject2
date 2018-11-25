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


public class GameRoom extends JFrame {
	private JPanel contentPane;
	static JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8;
	static JTextArea messageArea;
	static JTextPane textPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JPanel panel_31;
	static JFrame frame;
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

		contentPane = new JPanel();
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(1088, 709, 284, 34);
		contentPane.add(textField);

		messageArea = new JTextArea();
		messageArea.setBounds(1088, 42, 282, 666);
		contentPane.add(messageArea);
		messageArea.setEditable(false);

		panel1 = new JPanel() {

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user1.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel1.setBounds(61, 239, 191, 143);
		contentPane.add(panel1);

		panel2 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user2.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel2.setBounds(290, 239, 191, 143);
		contentPane.add(panel2);

		panel3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user3.getImage(), 0, 0, 191, 201, null);
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
		textField_1.setBounds(61, 197, 191, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 197, 191, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(529, 197, 191, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(772, 197, 191, 34);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(61, 452, 191, 34);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(290, 452, 191, 34);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(529, 452, 191, 34);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
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