package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class vote_d {
			static JFrame frame = new JFrame();
			JLabel msg = new JLabel("의사가 투표중입니다");
			Font font = new Font("맑은 고딕",Font.BOLD,40); //font ���� ���� ���� ���� ���Ƿ� �ֽ��ϴ�.
			public vote_d()
			{
				frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
				//Font ����
				msg.setFont(font);
				//������Ʈ�� ���� �����̳� ���ϱ�
				Container container = frame.getContentPane();
		        container.add(msg, BorderLayout.CENTER);
		        msg.setHorizontalAlignment(JLabel.CENTER);
		        msg.setForeground(Color.white);
		        frame.setBounds(600,300, 0, 0);
		        frame.getContentPane().setBackground(new Color(53,53,53));
				frame.setSize(750, 150);
				frame.setBackground(Color.black);
				frame.setResizable(false);
				frame.setUndecorated(true);
			}

			public static void main(String[] args)
			{
				new vote_d();
				vote_d.frame.setVisible(true);
			}
}
