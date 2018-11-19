package Project;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;

public class Mypage extends JFrame {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	String mypage_id, mypage_pw, mypage_name, mypage_age, mypage_ranking, mypage_score, mypage_victory, mypage_lose;

	/**
	 * Initialize the contents of the frame.
	 */
	public Mypage() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setTitle("My Information");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "My Information",
				TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.info));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(70, 25, 450, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel.setBounds(26, 30, 107, 49);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setForeground(SystemColor.menu);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(26, 90, 107, 49);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(26, 150, 107, 49);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setForeground(SystemColor.menu);
		lblNewLabel_3.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(26, 210, 107, 49);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(":");
		lblNewLabel_4.setForeground(SystemColor.menu);
		lblNewLabel_4.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(87, 30, 10, 49);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(":");
		lblNewLabel_5.setForeground(SystemColor.menu);
		lblNewLabel_5.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(87, 90, 10, 49);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(":");
		lblNewLabel_6.setForeground(SystemColor.menu);
		lblNewLabel_6.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(87, 150, 10, 49);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(":");
		lblNewLabel_7.setForeground(SystemColor.menu);
		lblNewLabel_7.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(87, 210, 10, 49);
		panel.add(lblNewLabel_7);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setForeground(Color.DARK_GRAY);
		textField.setBackground(SystemColor.info);
		textField.setFont(new Font("Gabriola", Font.PLAIN, 30));
		textField.setBounds(110, 35, 255, 40);
		panel.add(textField);
		textField.setColumns(15);

		textField1 = new JTextField();
		textField1.setBackground(SystemColor.info);
		textField1.setFont(new Font("Gabriola", Font.PLAIN, 30));
		textField1.setBounds(110, 95, 255, 40);
		panel.add(textField1);
		textField1.setColumns(15);
		textField1.setEnabled(false);

		textField2 = new JTextField();
		textField2.setBackground(SystemColor.info);
		textField2.setFont(new Font("Gabriola", Font.PLAIN, 30));
		textField2.setBounds(110, 155, 255, 40);
		panel.add(textField2);
		textField2.setColumns(15);
		textField2.setEnabled(false);

		textField3 = new JTextField();
		textField3.setBackground(SystemColor.info);
		textField3.setFont(new Font("Gabriola", Font.PLAIN, 30));
		textField3.setBounds(110, 215, 255, 40);
		panel.add(textField3);
		textField3.setColumns(15);
		textField3.setEnabled(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Game Score",
				TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.info));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(70, 350, 450, 200);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("Score  :");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setForeground(new Color(230, 230, 250));
		lblNewLabel_8.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(15, 40, 105, 35);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_12 = new JLabel("0");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12.setForeground(new Color(230, 230, 250));
		lblNewLabel_12.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_12.setBounds(120, 40, 105, 35);
		panel_1.add(lblNewLabel_12);

		JLabel lblNewLabel_9 = new JLabel("Ranking :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setForeground(new Color(230, 230, 250));
		lblNewLabel_9.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_9.setBounds(15, 125, 105, 35);
		panel_1.add(lblNewLabel_9);

		JLabel lblNewLabel_13 = new JLabel("0");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13.setForeground(new Color(230, 230, 250));
		lblNewLabel_13.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_13.setBounds(120, 125, 105, 35);
		panel_1.add(lblNewLabel_13);

		JLabel lblNewLabel_10 = new JLabel("Victory :");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setForeground(new Color(230, 230, 250));
		lblNewLabel_10.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(235, 40, 105, 35);
		panel_1.add(lblNewLabel_10);

		JLabel lblNewLabel_14 = new JLabel("0");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_14.setForeground(new Color(230, 230, 250));
		lblNewLabel_14.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_14.setBounds(340, 40, 105, 35);
		panel_1.add(lblNewLabel_14);

		JLabel lblNewLabel_11 = new JLabel("Lose  :");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setForeground(new Color(230, 230, 250));
		lblNewLabel_11.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_11.setBounds(235, 125, 105, 35);
		panel_1.add(lblNewLabel_11);

		JLabel lblNewLabel_15 = new JLabel("0");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_15.setForeground(new Color(230, 230, 250));
		lblNewLabel_15.setFont(new Font("Gabriola", Font.PLAIN, 30));
		lblNewLabel_15.setBounds(340, 125, 105, 35);
		panel_1.add(lblNewLabel_15);

		JButton btnNewButton = new JButton("modify");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setFont(new Font("Gabriola", Font.PLAIN, 23));
		btnNewButton.setBounds(190, 585, 100, 30);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(btnNewButton)) {
					textField1.setEnabled(true);
					textField2.setEnabled(true);
					textField3.setEnabled(true);
				}
			}
		});

		JButton btnNewButton_1 = new JButton("submit");
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setFont(new Font("Gabriola", Font.PLAIN, 23));
		btnNewButton_1.setBounds(310, 585, 100, 30);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(btnNewButton_1)) {
					textField1.setEnabled(false);
					textField2.setEnabled(false);
					textField3.setEnabled(false);
					Login.out.println("[MypageUpdate]");
					Login.out.println(textField.getText());
					Login.out.println(textField1.getText());
					Login.out.println(textField2.getText());
					Login.out.println(textField3.getText());
					System.out.println(textField.getText());
					System.out.println(textField1.getText());
					System.out.println(textField2.getText());
					System.out.println(textField3.getText());
					try {
						String line = Login.in.readLine();
						System.out.println("in="+line);
						JOptionPane.showMessageDialog(null, "기본 알림창입니다.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		frame.setBounds(screen.width / 2, 100, 600, 700);

		try {
			String line = Login.in.readLine();
			System.out.println(line);
			Login.out.println(Login.user_id);
			if (line.equals("mypage")) {
				mypage_id = Login.in.readLine();
				mypage_pw = Login.in.readLine();
				mypage_name = Login.in.readLine();
				mypage_age = Login.in.readLine();
				mypage_ranking = Login.in.readLine();
				mypage_victory = Login.in.readLine();
				mypage_score = Login.in.readLine();
				mypage_lose = Login.in.readLine();
				textField.setText(mypage_id);
				textField1.setText(mypage_pw);
				textField2.setText(mypage_name);
				textField3.setText(mypage_age);
				lblNewLabel_12.setText(mypage_score);
				lblNewLabel_13.setText(mypage_victory);
				lblNewLabel_14.setText(mypage_ranking);
				lblNewLabel_15.setText(mypage_lose);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Mypage client = new Mypage();
		// TODO Auto-generated method stub
	}
}
