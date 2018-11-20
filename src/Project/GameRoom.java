package Project;

import java.awt.Color;

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
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class GameRoom extends JFrame {
	private JPanel contentPane;
	static JTextField textField;
	static JTextArea messageArea;

	public static void main(String[] args) throws Exception {
		new GameRoom();

		// TODO Auto-generated method stub
	}

	public GameRoom() {
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(1088, 709, 284, 34);
		contentPane.add(textField);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(1088, 31, 280, 82);
		contentPane.add(btnNewButton);

		messageArea = new JTextArea();
		messageArea.setBounds(1088, 191, 282, 519);
		contentPane.add(messageArea);
		messageArea.setEditable(false);

		JPanel panel = new JPanel();
		panel.setBounds(14, 433, 248, 63);
		contentPane.add(panel);

		ButtonGroup grp = new ButtonGroup();
		JRadioButton[] rb = new JRadioButton[8];
		for (int i = 0; i < 8; i++)
			grp.add(rb[i]);
		rb[0] = new JRadioButton("User1");
		rb[0].setBounds(20, 515, 100
				, 27);
		contentPane.add(rb[0]);

		rb[1] = new JRadioButton("User2");
		rb[1].setBounds(120, 515, 100, 27);
		contentPane.add(rb[1]);

		rb[2] = new JRadioButton("User3");
		rb[2].setBounds(20, 565, 100, 27);
		contentPane.add(rb[2]);

		rb[3] = new JRadioButton("User4");
		rb[3].setBounds(120, 565, 100, 27);
		contentPane.add(rb[3]);

		rb[4] = new JRadioButton("User5");
		rb[4].setBounds(20, 615, 100, 27);
		contentPane.add(rb[4]);

		rb[5] = new JRadioButton("User6");
		rb[5].setBounds(120, 615, 100, 27);
		contentPane.add(rb[5]);

		rb[6] = new JRadioButton("User7");
		rb[6].setBounds(20, 665, 100, 27);
		contentPane.add(rb[6]);

		rb[7] = new JRadioButton("User8");
		rb[7].setBounds(120, 665, 100, 27);
		contentPane.add(rb[7]);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(14, 709, 248, 34);
		contentPane.add(btnNewButton_1);
		
		for(JRadioButton c : rb) {
			grp.add(c);
			contentPane.add(c);
		}

		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.out2.println(textField.getText());
				textField.setText("");
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1400, 800);
		setVisible(true);
		ChatThread runnable1 = new ChatThread();
		Thread Thread1 = new Thread(runnable1);
		Thread1.start();
	}
}