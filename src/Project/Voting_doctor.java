package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Voting_doctor extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	static JButton button, button_1, button_2, button_3, button_4, button_5, button_6, button_7, btnNewButton;
	static JTextPane textPane;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Voting_doctor start = new Voting_doctor();
	}

	public Voting_doctor() {

		frame = new JFrame("Voting");
		contentPane = new JPanel();
		contentPane.setLayout(null);

		frame.setContentPane(contentPane);

		button = new JButton("");
		button.setBounds(43, 110, 140, 46);
		contentPane.add(button);

		button_1 = new JButton("");
		button_1.setBounds(43, 168, 140, 46);
		contentPane.add(button_1);

		button_2 = new JButton("");
		button_2.setBounds(43, 226, 140, 46);
		contentPane.add(button_2);

		button_3 = new JButton("");
		button_3.setBounds(43, 296, 140, 46);
		contentPane.add(button_3);

		button_4 = new JButton("");
		button_4.setBounds(283, 110, 140, 46);
		contentPane.add(button_4);

		button_5 = new JButton("");
		button_5.setBounds(283, 168, 140, 46);
		contentPane.add(button_5);

		button_6 = new JButton("");
		button_6.setBounds(283, 226, 140, 46);
		contentPane.add(button_6);

		button_7 = new JButton("");
		button_7.setBounds(283, 296, 140, 46);
		contentPane.add(button_7);

		textPane = new JTextPane();
		textPane.setBounds(110, 12, 257, 56);
		contentPane.add(textPane);

		btnNewButton = new JButton("투표하기");
		btnNewButton.setBounds(43, 369, 375, 56);
		contentPane.add(btnNewButton);

		frame.setBounds(200, 50, 500, 500);
		frame.setVisible(true);
	}
}
