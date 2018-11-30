package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Voting_doctor extends JFrame {
	
	private JPanel contentPane;
	static JFrame frame;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Voting_doctor start = new Voting_doctor();
	}
	
	public Voting_doctor() {

		frame = new JFrame("Voting");
		contentPane = new JPanel();
		contentPane.setLayout(null);

		frame.setContentPane(contentPane);
		frame.setBounds(200, 50, 500, 500);
		frame.setVisible(true);
	}
}
