package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Panel;
import javax.swing.JButton;

public class CreateAccount extends JFrame {
	private JPanel contentPane;
	public static CreateAccount main;
	public CreateAccount()
	{
		ImageIcon Id = new ImageIcon("Image/png/user/id.png");
		ImageIcon Password = new ImageIcon("Image/png/user/password.png");
		ImageIcon Age = new ImageIcon("Image/png/user/age.png");
		ImageIcon Name = new ImageIcon("Image/png/user/name.png");
		ImageIcon Title = new ImageIcon("Image/png/user/create_new_account.png");
		ImageIcon Submit = new ImageIcon("Image/png/user/submit.png");
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		TextField textField1= new TextField();
		textField1.setBounds(159, 87, 242, 45);
		contentPane.add(textField1);
		textField1.setColumns(10);
		Font f1 = new Font("ÈÞ¸Õ¸ðÀ½T",Font.BOLD,30);
		textField1.setFont(f1);
		
		TextField textField2 = new TextField();
		textField2.setBounds(159, 169, 242, 45);
		contentPane.add(textField2);
		textField2.setColumns(10);
		Font f2 = new Font("ÈÞ¸Õ¸ðÀ½T",Font.BOLD,30);
		textField2.setFont(f2);
		
		TextField textField3 = new TextField();
		textField3.setBounds(159, 241, 242, 45);
		contentPane.add(textField3);
		textField3.setColumns(10);
		Font f3 = new Font("ÈÞ¸Õ¸ðÀ½T",Font.BOLD,30);
		textField3.setFont(f3);
		
		TextField textField4 = new TextField();
		textField4.setBounds(159, 322, 242, 45);
		contentPane.add(textField4);
		textField4.setColumns(10);
		Font f4 = new Font("ÈÞ¸Õ¸ðÀ½T",Font.BOLD,30);
		textField4.setFont(f4);
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Id.getImage(), 0, 0, 80,30, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel.setBounds(20, 87, 114, 45);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Password.getImage(), 0, 0, 80,30, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_1.setBounds(20, 169, 114, 45);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Name.getImage(), 0, 0, 80 ,30, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_2.setBounds(20, 241, 114, 45);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Age.getImage(), 0, 0, 80,30, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_3.setBounds(20, 322, 114, 45);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Title.getImage(), 0, 0, 285,50, null);
				setOpaque(false);
				
				super.paintComponent(g);
			}
		};
		panel_4.setBounds(94, 10, 285, 65);
		contentPane.add(panel_4);
		
		Image originImg = Submit.getImage();
		Image changedImg= originImg.getScaledInstance(116, 30, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		JButton btnNewButton = new JButton(Icon);
		btnNewButton.setBounds(116, 392, 249, 49);
		contentPane.add(btnNewButton);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(btnNewButton)) {
					String id = textField1.getText().trim();
					String pw = textField2.getText().trim();
					String name = textField3.getText().trim();
					String age = textField4.getText().trim();
					try {
						Login.out.println("[CreateAccount]");
						Login.out.println(id);
						Login.out.println(pw);
						Login.out.println(name);
						Login.out.println(age);
						String line = Login.in.readLine();
						System.out.println(line);
						if(line.equals("Success")) {
							System.out.println("Success to regist");
							setVisible(false);
						}
						else
							System.out.println("ID exist");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 500, 500);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main = new CreateAccount();
		main.setVisible(true);
	}
}