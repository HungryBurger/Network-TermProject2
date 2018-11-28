package Project;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Voting extends JFrame {
	
	private JPanel contentPane;
	static JFrame frame;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Voting_mafia start = new Voting_mafia();
	}
	
	public Voting() {

		frame = new JFrame("Voting");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		
		
		
		setContentPane(contentPane);
		setBounds(100, 50, 1400, 800);
		setVisible(true);
		
		
	}
}
