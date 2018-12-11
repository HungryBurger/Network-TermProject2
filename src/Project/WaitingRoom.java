package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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

import java.awt.*;

public class WaitingRoom extends JFrame {
	private JPanel contentPane;
	static JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,textField_8;
	static JTextArea messageArea;
	static JPanel panel1;
	static JPanel panel2;
	static JPanel panel3;
	static JPanel panel4;
	static JPanel panel5;
	static JPanel panel6;
	static JPanel panel7;
	static JPanel panel8;
	private JPanel Title;
	static JFrame frame;
	private static int btn_ready_count = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WaitingRoom wait = new WaitingRoom();
	}

	public WaitingRoom() {
		
		Image change = null;
		frame = new JFrame("WaitingRoom");
		ImageIcon user1 = new ImageIcon("Image/user1.png");
		ImageIcon user2 = new ImageIcon("Image/user2.png");
		ImageIcon user3 = new ImageIcon("Image/user3.png");
		ImageIcon user4 = new ImageIcon("Image/user4.png");
		ImageIcon user5 = new ImageIcon("Image/user5.png");
		ImageIcon user6 = new ImageIcon("Image/user6.png");
		ImageIcon user7 = new ImageIcon("Image/user7.png");
		ImageIcon user8 = new ImageIcon("Image/user8.png");
		ImageIcon title = new ImageIcon("Image/png/gameScreen/Waiting_room.png");
		ImageIcon back  = new ImageIcon("Image/png/gameScreen/back.png");
		ImageIcon ready = new ImageIcon("Image/png/gameScreen/ready.png");
		ImageIcon n1 = new ImageIcon("Image/png/gameScreen/1.png");
		ImageIcon n2 = new ImageIcon("Image/png/gameScreen/2.png");
		ImageIcon n3 = new ImageIcon("Image/png/gameScreen/3.png");
		ImageIcon n4 = new ImageIcon("Image/png/gameScreen/4.png");
		ImageIcon n5 = new ImageIcon("Image/png/gameScreen/5.png");
		ImageIcon n6 = new ImageIcon("Image/png/gameScreen/6.png");
		ImageIcon n7 = new ImageIcon("Image/png/gameScreen/7.png");
		ImageIcon n8 = new ImageIcon("Image/png/gameScreen/8.png");


		

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
		
        change = ready.getImage();
        change = change.getScaledInstance(280, 100, Image.SCALE_SMOOTH);
        
		JButton Ready = new JButton(new ImageIcon(change));
		Ready.setBounds(1088, 31, 280, 111);
		contentPane.add(Ready);
		Ready.setBorderPainted(false);
		Ready.setContentAreaFilled(false);
		Ready.setFocusPainted(false);
		Ready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(Ready)) {
					if (btn_ready_count == 0) {
						Login.out.println("Ready");
						btn_ready_count = 1;
						System.out.println("User Count = " + btn_ready_count);
					} else if (btn_ready_count == 1) {
						Login.out.println("NotReady");
						btn_ready_count = 0;
						System.out.println("User Count = " + btn_ready_count);
					}
				}
			}
		});

		messageArea = new JTextArea();
		messageArea.setBounds(1088, 191, 282, 517);
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
		panel1.setBounds(61, 191, 191, 201);
		contentPane.add(panel1);
		panel1.setLayout(null);
		

		panel2 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user2.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel2.setBounds(290, 191, 191, 201);
		contentPane.add(panel2);

		panel3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user3.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel3.setBounds(529, 193, 191, 201);
		contentPane.add(panel3);

		panel4 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user4.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel4.setBounds(772, 191, 191, 201);
		contentPane.add(panel4);

		panel5 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user5.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel5.setBounds(61, 468, 191, 201);
		contentPane.add(panel5);

		panel6 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user6.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
		panel6.setBounds(290, 468, 191, 201);
		contentPane.add(panel6);
		
		panel7 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user7.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel7.setBounds(529, 468, 191, 201);
		contentPane.add(panel7);

		panel8 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(user8.getImage(), 0, 0, 191, 201, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel8.setBounds(772, 468, 191, 201);
		contentPane.add(panel8);

		Title = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(title.getImage(), 0, 0, 798, 111, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		Title.setBounds(121, 31, 798, 111);
		contentPane.add(Title);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_1.setBounds(61, 406, 191, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(290, 404, 191, 34);
		textField_2.setEditable(false);
		
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_3.setColumns(10);
		textField_3.setBounds(529, 406, 191, 34);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_4.setColumns(10);
		textField_4.setBounds(772, 404, 191, 34);
		contentPane.add(textField_4);
		textField_4.setEditable(false);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_5.setColumns(10);
		textField_5.setBounds(61, 681, 191, 34);
		contentPane.add(textField_5);
		textField_5.setEditable(false);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_6.setColumns(10);
		textField_6.setBounds(290, 681, 191, 34);
		contentPane.add(textField_6);
		textField_6.setEditable(false);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_7.setColumns(10);
		textField_7.setBounds(529, 681, 191, 34);
		contentPane.add(textField_7);
		textField_7.setEditable(false);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Gabriola", Font.BOLD, 30));
		textField_8.setColumns(10);
		textField_8.setBounds(772, 681, 191, 34);
		contentPane.add(textField_8);
		textField_8.setEditable(false);
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel5.setVisible(false);
		panel6.setVisible(false);
		panel7.setVisible(false);
		panel8.setVisible(false);
		
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
		 * JButton btnNewButton_1 = new JButton("Ȯ��"); btnNewButton_1.setBounds(14, 709,
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
		
		
		JPanel panel1_1 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n1.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel1_1.setBounds(0, 0, 25, 30);
		panel1.add(panel1_1);
		panel1.setLayout(null);
		
		JPanel panel2_1 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n2.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel2_1.setBounds(0, 0, 25, 30);
		panel2.add(panel2_1);
		panel2.setLayout(null);
		
		JPanel panel3_1 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n3.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel3_1.setBounds(0, 0, 25, 30);
		panel3.add(panel3_1);
		panel3.setLayout(null);
		
		JPanel panel4_1 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n4.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel4_1.setBounds(0, 0, 25, 30);
		panel4.add(panel4_1);
		panel4.setLayout(null);
		
		JPanel panel5_1 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n5.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel5_1.setBounds(0, 0, 25, 30);
		panel5.add(panel5_1);
		panel5.setLayout(null);
		
		JPanel panel6_1 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n6.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel6_1.setBounds(0, 0, 25, 30);
		panel6.add(panel6_1);
		panel6.setLayout(null);
		
		JPanel panel7_1 = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n1.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel7_1.setBounds(0, 0, 25, 30);
		panel7.add(panel7_1);
		panel7.setLayout(null);
		
		JPanel panel8_1 = new JPanel() {
			 
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(n8.getImage(), 0, 0, 25,30, null);
				setOpaque(false);
				super.paintComponent(g);
		}};
		panel8_1.setBounds(0, 0, 25, 30);
		panel8.add(panel8_1);
		panel8.setLayout(null);
		
		
		
		frame.setVisible(true);
		frame.setBounds(100, 50, 1400, 800);
		ChatThread runnable1 = new ChatThread();
		Thread Thread1 = new Thread(runnable1);
		Thread1.start();
		WaitingRoomThread runnable2 = new WaitingRoomThread();
		Thread Thread2 = new Thread(runnable2);
		Thread2.start();
	}
}