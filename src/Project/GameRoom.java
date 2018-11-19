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

public class GameRoom extends JFrame {
	private JPanel contentPane;
	static JTextField textField;
	static JTextArea messageArea;

	public static void main(String[] args) throws Exception {
		
		
		// TODO Auto-generated method stub
	}

	public GameRoom() {
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(1088, 709, 284, 34);
		contentPane.add(textField);

		messageArea = new JTextArea();
		messageArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(messageArea);
		scrollPane.setBounds(1088, 388, 284, 322);
		contentPane.add(scrollPane);
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