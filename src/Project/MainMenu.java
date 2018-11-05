package Project;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MainMenu extends JFrame{
	public static MainMenu main;
	private JPanel contentPane;
	ImageIcon Start = new ImageIcon("Image/Gamestart.png");
	ImageIcon Ranking = new ImageIcon("Image/Ranking.png");
	ImageIcon Personal = new ImageIcon("Image/Mypage.png");
	
	ImageIcon Title = new ImageIcon("Image/Mainmenu_title.png");
	ImageIcon MainMenu_back = new ImageIcon("Image/MainMenu_back.jpg");
	
	public MainMenu()
	{
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(MainMenu_back.getImage(), 0, 0, 1200, 800, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Image originImg = Start.getImage();
		Image changedImg= originImg.getScaledInstance(456,139, Image.SCALE_SMOOTH );
		ImageIcon Icon = new ImageIcon(changedImg);
		
		JButton button1 = new JButton(Icon);
		button1.setBounds(92, 187, 456, 139);
		contentPane.add(button1);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		
		originImg = Ranking.getImage();
		changedImg= originImg.getScaledInstance(456,139, Image.SCALE_SMOOTH );
		Icon = new ImageIcon(changedImg);
		JButton button2 = new JButton(Icon);
		button2.setBounds(92, 360, 456, 139);
		contentPane.add(button2);
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button2.setFocusPainted(false);
		
		originImg = Personal.getImage();
		changedImg= originImg.getScaledInstance(456,139, Image.SCALE_SMOOTH );
		Icon = new ImageIcon(changedImg);
		JButton button3 = new JButton(Icon);
		button3.setBounds(92, 534, 456, 139);
		contentPane.add(button3);
		button3.setBorderPainted(false);
		button3.setContentAreaFilled(false);
		button3.setFocusPainted(false);
		
		JPanel panel1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(Title.getImage(), 0, 0, 968, 119, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		panel1.setBounds(92, 36, 968, 119);
		contentPane.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(640, 187, 417, 486);
		contentPane.add(panel2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1200, 800);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainMenu().setVisible(true);
	}
}