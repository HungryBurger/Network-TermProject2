package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Voting_mafia extends JFrame {
	
	private JPanel contentPane;
	static JFrame frame;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Voting_mafia start = new Voting_mafia();
	}
	
	public Voting_mafia() {

		frame = new JFrame("Voting_mafia");
		contentPane = new JPanel();
		contentPane.setLayout(null);

		frame.setContentPane(contentPane);
		frame.setBounds(200, 50, 500, 500);
		frame.setVisible(true);
	}
}
