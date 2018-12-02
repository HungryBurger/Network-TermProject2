package Project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.Panel;
import java.awt.SystemColor;

public class Login extends JFrame {
	public static Login clients;
	public static Clip clip;
	private JPanel contentPane;
	public static BufferedReader in, in2;
	public static PrintWriter out, out2;
	public static BufferedReader input;
	public static PrintWriter output;
	public static Image originImg, changedImg;
	public static ImageIcon Icon;
	public static String user_id;
	JButton button1, button2;

	public void run() throws IOException {
		// Make connection and initialize streams
		Socket socket = new Socket("127.0.0.1", 9001);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		System.out.println("Succes to open socket");
	}

	public void run2() throws IOException {
		// Make connection and initialize streams
		System.out.println("socket2");
		Socket socket2 = new Socket("127.0.0.1", 9003);
		in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
		out2 = new PrintWriter(socket2.getOutputStream(), true);
		System.out.println("Succes to open socket2");
	}

	public static void main(String[] args) throws Exception {
		clients = new Login();
		// clients.sound("bgm/Opening_bgm.wav", true);
		clients.setVisible(true);
		clients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clients.run();
		clients.run2();
	}

	/**
	 * Create the frame.
	 */

	public Login() {
		ImageIcon Log_back = new ImageIcon("Image/png/login/login_back.png");
		ImageIcon Title = new ImageIcon("Image/Title.png");
		ImageIcon Login = new ImageIcon("Image/png/login/login.png");
		ImageIcon Id = new ImageIcon("Image/png/login/id.png");
		ImageIcon Password = new ImageIcon("Image/png/login/password.png");
		ImageIcon account = new ImageIcon("Image/png/login/creat.png");

		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Log_back.getImage(), 0, 0, 1200, 800, null);
				setOpaque(false);
				super.paintComponent(g);
		}
		};
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1200, 800);

		TextField textField1 = new TextField();
		textField1.setBounds(555, 480, 285, 46);
		contentPane.add(textField1);
		textField1.setColumns(10);
		Font f1 = new Font("Gabriola", Font.PLAIN, 30);
		textField1.setFont(f1);

		TextField textField2 = new TextField();
		textField2.setBounds(555, 542, 285, 46);
		contentPane.add(textField2);
		textField2.setColumns(10);

		Font f2 = new Font("Gabriola", Font.PLAIN, 30);
		textField2.setEchoChar('*');
		textField2.setFont(f2);

		Image originImg = Login.getImage();
		Image changedImg = originImg.getScaledInstance(171, 53, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		button1 = new JButton(Icon);
		button1.setBounds(268, 650, 171, 53);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		contentPane.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj.equals(button1)) {
					String id = textField1.getText().trim();
					String pw = textField2.getText().trim();
					try {
						out.println("[login]");
						out.println(id);
						out.println(pw);
						String line = in.readLine();
						System.out.println(line);
						if (line.equals("Success")) {
							System.out.println("Login success");
							user_id = id;
							setVisible(false);
							new MainMenu().setVisible(true);
						} else
							System.out.println("Check the ID or Password");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		originImg = account.getImage();
		changedImg = originImg.getScaledInstance(342, 53, Image.SCALE_SMOOTH);
		Icon = new ImageIcon(changedImg);
		JButton button2 = new JButton(Icon);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CreateAccount().setVisible(true);
			}
		});
		button2.setBounds(529, 650, 342, 53);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		contentPane.add(button2);

		JPanel panel1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Id.getImage(), 0, 0, 166, 46, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel1.setBounds(322, 480, 166, 46);
		contentPane.add(panel1);

		JPanel panel_2 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Password.getImage(), 0, 0, 166, 46, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel_2.setBounds(322, 542, 166, 46);
		contentPane.add(panel_2);

		JPanel panel3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Title.getImage(), 0, 0, 872, 165, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel3.setBounds(156, 48, 872, 165);
		contentPane.add(panel3);
	}

	public void sound(String file, boolean Loop) {
		// 사운드재생용메소드
		// 메인 클래스에 추가로 메소드를 하나 더 만들었습니다.
		// 사운드파일을받아들여해당사운드를재생시킨다.
		try {
			if (clip != null)
				clip.stop();
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();

			if (Loop)
				clip.loop(-1);
			// Loop 값이true면 사운드재생을무한반복시킵니다.
			// false면 한번만재생시킵니다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}