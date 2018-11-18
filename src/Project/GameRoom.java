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

public class GameRoom extends JFrame implements Runnable {
	private JPanel contentPane;
	JTextField textField;
	JTextArea messageArea;
	BufferedReader in;
	PrintWriter out;

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
				out.println(textField.getText());
				textField.setText("");
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1400, 800);
		setVisible(true);
		run();
	}

	@Override
	public void run() {
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 9003);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				// Read line from server
				String line = in.readLine();
				System.out.println(line);
				if (line.startsWith("SUBMITNAME")) {
					out.println(Login.user_id);
				} else if (line.startsWith("NAMEACCEPTED")) {
					textField.setEditable(true);
					messageArea.setEditable(true);
				} else if (line.startsWith("FIRST")) {
					messageArea.append(line.substring(5) + "\n");
				} else if (line.startsWith("MESSAGE")) {
					messageArea.append(line.substring(8) + "\n");
				} else if (line.startsWith("ENTRANCE")) { // Entrance prototype
					messageArea.append(line.substring(9) + "\n");
				} else if (line.startsWith("EXIT")) { // Exit prototype
					messageArea.append(line.substring(5) + "\n");
				} else if (line.startsWith("WHISPER")) { // whisper prototype
					messageArea.append(line.substring(8) + "\n");
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}