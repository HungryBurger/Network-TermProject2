package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;

public class Voting_mafia extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	static JButton button, button_1, button_2, button_3, button_4, button_5, button_6, button_7, btnNewButton;
	static JTextPane textPane;
	

	ImageIcon back =  new ImageIcon("Image/png/vote/back.png");


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Voting start = new Voting();
	}

	public Voting_mafia() {

		frame = new JFrame("Voting Mafia");
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

		button = new JButton();
		button.setBackground(Color.WHITE);
		button.setBounds(43, 110, 140, 46);
		button.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button)) {
					textPane.setText(button.getText());
				}
			}
		});

		button_1 = new JButton();
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(43, 168, 140, 46);
		button_1.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button_1)) {
					textPane.setText(button_1.getText());
				}
			}
		});

		button_2 = new JButton();
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(43, 226, 140, 46);
		button_2.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button_2)) {
					textPane.setText(button_2.getText());
				}
			}
		});

		button_3 = new JButton();
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(43, 296, 140, 46);
		button_3.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button_3)) {
					textPane.setText(button_3.getText());
				}
			}
		});

		button_4 = new JButton();
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(283, 110, 140, 46);
		button_4.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button_4);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button_4)) {
					textPane.setText(button_4.getText());
				}
			}
		});

		button_5 = new JButton();
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(283, 168, 140, 46);
		button_5.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button_5);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button_5)) {
					textPane.setText(button_5.getText());
				}
			}
		});

		button_6 = new JButton();
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(283, 226, 140, 46);
		button_6.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button_6);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button_6)) {
					textPane.setText(button_6.getText());
				}
			}
		});

		button_7 = new JButton();
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(283, 296, 140, 46);
		button_7.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(button_7);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button_7)) {
					textPane.setText(button_7.getText());
				}
			}
		});

		textPane = new JTextPane();
		textPane.setBounds(110, 12, 257, 56);
		textPane.setFont(new Font("Gabriola", Font.BOLD, 30));
		contentPane.add(textPane);
        
		
		
		btnNewButton = new JButton("vote");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(43, 369, 375, 56);
		btnNewButton.setFont(new Font("Gabriola", Font.BOLD, 50));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(btnNewButton)) {
					Login.out.println("[Mafia_Result]"+textPane.getText());
					System.out.println("[Mafia_Result]"+textPane.getText());
					frame.setVisible(false);
				}
			}
		});

		frame.setBounds(200, 50, 500, 500);
		frame.setVisible(true);
	}
}
