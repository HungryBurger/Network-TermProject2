package Project;

import java.awt.*;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.*;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;
import java.util.Random;

public class Server extends JFrame implements ActionListener {

	// jdbc set
	private String url = "jdbc:mysql://localhost:8000/network?serverTimezone=UTC&useSSL=false";// user테이my블을 수정하면
	private String strUser = "root"; // 계정 id
	private String strPassword = "12345"; // 계정 패스워드
	private String strMySQLDriver = "com.mysql.cj.jdbc.Driver"; // 드라이버 이름 따로 만들어줌
	private static final int PORT = 9001;

	// For socket Connection
	Connection con;
	Statement stmt;
	ResultSet rs;

	String sql; // sql query
	String pass; // password
	String name; // name
	int age;
	int CHECK_FORCE = 0;

	// Call Login page
	Login log = new Login(); // true
	CreateAccount create = new CreateAccount();
	MainMenu menu = new MainMenu();

	// DB Connection
	private static class Handler extends Thread {
		private String Check_Class;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				while (true) {
					Check_Class = in.readLine();
					if (Check_Class.startsWith("[login]") == true) {
						String id = in.readLine();
						String pw = in.readLine();
						System.out.println(id);
						System.out.println(pw);

						int temp = new Server().loginCheck(id, pw);
						if (temp == 1)
							out.println("Success");
						else
							out.println("Fail");

					} else if (Check_Class.startsWith("[CreateAccount]") == true) {

						String id = in.readLine();
						String pw = in.readLine();
						String name = in.readLine();
						String age = in.readLine();

						System.out.println(id);
						System.out.println(pw);
						System.out.println(name);
						System.out.println(age);
						int temp = new Server().selectInsert(id, pw, name, age);
						if (temp == 1)
							out.println("Success");
						else
							out.println("Fail");
					} else if (Check_Class.startsWith("[Ranking]") == true) {
						String id = in.readLine();
						String pw = in.readLine();
						System.out.println(id);
						System.out.println(pw);
						int temp = new Server().loginCheck(id, pw);
						if (temp == 1)
							out.println("Success");
						else
							out.println("Fail");
					}

				}
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public Server() {
		try {
			// 로그인 버튼이 클릭 되었을시에 jdbc드라이버를 등록한다.
			Class.forName(strMySQLDriver);
			// DriverManager로부터 커넥션을 얻어오는데 mysql서버 . id, pw 등을 언어온다.
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			// 커넥션으로부터 실제로 sql쿼리 실행시키기 위한 statement 객체를 얻어온다.
			stmt = (Statement) con.createStatement();
			System.out.println("DB Connection Success");
		} catch (Exception b) {
			System.out.println("DB Connection Failed");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 해당하는 버튼값 가져오기
		Object obj = e.getSource();
	}

	//Add user
	int selectInsert(String id, String pw, String name, String age) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.id = id;
		d.pw = pw;
		d.name = name;
		d.age = age;
		System.out.println(id + pw + name + age);
		String sql = "insert into user value('" + d.id + "','" + d.pw + "','" + d.name + "'," + Integer.parseInt(d.age)
				+ ",0,0,0,0)";
		String sql2 = "SELECT pw,name FROM user where id='" + id + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql2);
			System.out.println(sql2);
			CHECK_FORCE = 0;
			if (!rs.next()) {
				int rss = stmt.executeUpdate(sql);
				System.out.println(rss + "번째 삽입");
				CHECK_FORCE = 1;
			} else {
				System.out.println("존재하는 아이디입니다");
				CHECK_FORCE = 0;
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println(CHECK_FORCE);
		return CHECK_FORCE;
	}
	// Check login
	int loginCheck(String id, String pass) {
		// SELECT 쿼리를 작성한다. 해당하는 아이디값의 패스워드를 검색한다.
		String query = "SELECT pw,name FROM user where id='" + id + "'";
		System.out.println(query);
		try {
			// executeQuery() 메서드로 SELECT문의 실행시키고 결과로 ResultSet 객체를 받는다.
			ResultSet rs = stmt.executeQuery(query);
			// 레코드가 있는지 검사
			if (rs.next()) {
				CHECK_FORCE = 0;
				name = rs.getString("name");
				// 텍스트필드에 쓴값과 데이터베이스에 있는 패스워드 값을 비교한다.
				if (pass.equals(rs.getString("pw"))) {
					System.out.println("일치한다");
					CHECK_FORCE = 1;
					// 맞으면 로그인서브를 띄워준다.
				} else {
					System.out.println("일치하지않는다");
					CHECK_FORCE = 0;
				}
			} else {
				System.out.println("doesn't exist");
			}
		} catch (Exception b) {
			b.printStackTrace();
		}
		return CHECK_FORCE;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("The Server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Server();
				new Handler(listener.accept()).start();
			}
		} finally {
			listener.close();
		}
	}
}