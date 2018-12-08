package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class vote_d {
	//컴포넌트 생성
			static JFrame frame = new JFrame();
			JLabel msg = new JLabel("의사의 투표가 진행중입니다");
			Font font = new Font("맑은고딕",Font.BOLD,40); //font 통일 뭘로 할지 몰라 임의로 넣습니다.
			public vote_d()
			{
				//위 표시줄 제거하기(사용자가 임의로 창 못 닫게 하려고 추가했습니다.)
				
				frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
				//Font 적용
				msg.setFont(font);
				//컴포넌트를 넣을 컨테이너 구하기
				Container container = frame.getContentPane();
		        container.add(msg, BorderLayout.CENTER);
		        msg.setHorizontalAlignment(JLabel.CENTER);
		        msg.setForeground(Color.white);
		        frame.setBounds(600,300, 0, 0);
		        frame.getContentPane().setBackground(new Color(53,53,53));
				//프레임 크기 지정
				frame.setSize(750, 150);
				frame.setBackground(Color.black);
				frame.setResizable(false);
				//프레임 보이기 설정
				frame.setUndecorated(true);
			}

			public static void main(String[] args)
			{
				//실행
				new vote_d();
				vote_d.frame.setVisible(true);
			}
}
