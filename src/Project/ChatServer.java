package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.lang.String;

public class ChatServer {
	private static final int PORT = 9003;
	private static HashSet<String> names = new HashSet<String>();
	private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	private static HashMap<String, PrintWriter> map = new HashMap<String, PrintWriter>();
	
	public static void main(String[] args) throws Exception {
		System.out.println("The chat server is running.");
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				new Handler(listener.accept()).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class Handler extends Thread {
		private String name;
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;

		/*
		 * Constructs a handler thread, squirreling away the socket. All the interesting
		 * work is done in the run method.
		 */
		public Handler(Socket socket) {
			this.socket = socket;
		}

		/*
		 * Services this thread's client by repeatedly requesting a screen name until a
		 * unique one has been submitted, then acknowledges the name and registers the
		 * output stream for the client in a global set, then repeatedly gets inputs and
		 * broadcasts them.
		 */
		public void run() {
			try {
				// Create character streams for the socket.
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				// Request a name from this client. Keep requesting until
				// a name is submitted that is not already used. Note that
				// checking for the existence of a name and adding the name
				// must be done while locking the set of names.
				while (true) {
					out.println("SUBMITNAME");
					name = in.readLine();
					if (name == null) {
						return;
					}
					synchronized (names) {
						if (!names.contains(name)) {
							names.add(name);
							break;
						}
					}
				}
				out.println("NAMEACCEPTED");
				writers.add(out);
				// Input the HasMap
				map.put(name, out);
				// Print the message box that print the whisper format
				out.println("FIRST" + "귓속말 형식 -> /r 또는 /ㄱ 아이디  + 내용을 입력하세요");
				// Print the
				for (PrintWriter writer : writers) {
					writer.println("ENTRANCE " + name + "님이 입장하셨습니다. ");
				}
				// Accept messages from this client and broadcast them.
				// Ignore other clients that cannot be broadcasted to.
				while (true) {
					String input = in.readLine();
					if (input == null) {
						return;
					}
					// If client type the "/r" "/��", Apply a whisper
					if (input.startsWith("/r") || input.startsWith("/ㄱ")) {
						String[] temp_name;
						temp_name = input.split(" ");
						map.get(temp_name[1]).println(
								"WHISPER " + name + "님으로부터 귓속말이 왔습니다 : " + input.substring(input.indexOf(" ", 4)));
						out.println("WHISPER " + "<whisper to " + temp_name[1] + ">" + name + ":"
								+ input.substring(input.indexOf(" ", 4)));
					}else if(input.startsWith("[GameStart]")) {
						break;
					}
					else {
						// Print all client
						for (PrintWriter writer : writers) {
							writer.println("MESSAGE " + name + ": " + input);
						}
					}
				}
				
				out.println("G_First" + "귓속말 형식 -> /r 또는 /ㄱ 아이디  + 내용을 입력하세요");
				// Print the
				for (PrintWriter writer : writers) {
					writer.println("G_ENTRANCE " + name + "님이 입장하셨습니다.");
				}
				while(true) {
					String input = in.readLine();
					if (input == null) {
						return;
					}
					// If client type the "/r" "/��", Apply a whisper
					if (input.startsWith("/r") || input.startsWith("/��")) {
						String[] temp_name;
						temp_name = input.split(" ");
						map.get(temp_name[1]).println(
								"G_WHISPER " + name + "님으로부터 귓속말이 왔습니다. : " + input.substring(input.indexOf(" ", 4)));
						out.println("G_WHISPER " + "<whisper to " + temp_name[1] + ">" + name + ":"
								+ input.substring(input.indexOf(" ", 4)));
					}
					
					else {
						// Print all client
						for (PrintWriter writer : writers) {
							writer.println("G_MESSAGE " + name + ": " + input);
						}
					}
				}
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				// This client is going down! Remove its name and its print
				// writer from the sets, and close its socket.
				// Get out from chat room and print the
				for (PrintWriter writer : writers) {
					writer.println("EXIT " + name + "님이 퇴장하셨습니다.");
				}
				if (name != null) {
					names.remove(name);
				}
				if (out != null) {
					writers.remove(out);
				}
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}