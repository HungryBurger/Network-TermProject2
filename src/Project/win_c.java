package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class win_c {

	//������Ʈ ����
		JFrame frame = new JFrame();
		JLabel msg = new JLabel("�ù��� �¸��߽��ϴ�");
		Font font = new Font("�������",Font.BOLD,40); //font ���� ���� ���� ���� ���Ƿ� �ֽ��ϴ�.
		public win_c()
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
	        frame.getContentPane().setBackground(new Color(53,53,53));
			//������ ũ�� ����
	        frame.setBounds(600,300, 0, 0);
			frame.setSize(750, 150);
			frame.setBackground(Color.black);
			frame.setResizable(false);
			//������ ���̱� ����
			frame.setVisible(true);
			
			//���� ��ư ����
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		public static void main(String[] args)
		{
			//����
			new win_c();
		}
}
