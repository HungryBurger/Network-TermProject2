package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class Im_doctor {

	//������Ʈ ����
	static JFrame frame = new JFrame();
	JLabel msg = new JLabel("당신은 의사입니다");
	Font font = new Font("맑은고딕",Font.BOLD,40); //font ���� ���� ���� ���� ���Ƿ� �ֽ��ϴ�.
	public Im_doctor()
	{
		//�� ǥ���� �����ϱ�(����ڰ� ���Ƿ� â �� �ݰ� �Ϸ��� �߰��߽��ϴ�.)
		frame.setUndecorated(true);
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
		//������ ũ�� ����
		frame.setSize(750, 150);
		frame.setBackground(Color.black);
		frame.setResizable(false);
		//������ ���̱� ����
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		//����
		new Im_mafia();
	}
}
