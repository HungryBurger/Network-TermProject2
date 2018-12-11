package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class start {

	// ������Ʈ ����
	static JFrame frame = new JFrame();
	JLabel msg = new JLabel("게임을 시작합니다.");
	Font font = new Font("맑은 고딕", Font.BOLD, 40); // font ���� ���� ���� ���� ���Ƿ� �ֽ��ϴ�.

	public start() {
		// �� ǥ���� �����ϱ�(����ڰ� ���Ƿ� â �� �ݰ� �Ϸ��� �߰��߽��ϴ�.)
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		// Font ����
		msg.setFont(font);
		// ������Ʈ�� ���� �����̳� ���ϱ�
		Container container = frame.getContentPane();
		container.add(msg, BorderLayout.CENTER);
		msg.setHorizontalAlignment(JLabel.CENTER);
		msg.setForeground(Color.white);
		frame.setBounds(600, 300, 0, 0);
		frame.getContentPane().setBackground(new Color(53, 53, 53));
		// ������ ũ�� ����
		frame.setSize(750, 150);
		frame.setBackground(Color.black);
		frame.setResizable(false);
		frame.setUndecorated(true);
	}

	public static void main(String[] args) {
		// ����
		new start().frame.setVisible(true);
	}
}
