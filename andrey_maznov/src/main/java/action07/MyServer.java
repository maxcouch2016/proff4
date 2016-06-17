package action07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer extends Thread {

	private ServerSocket server;
	private final int port;
	private volatile String message;
	private volatile static int index;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MyServer(int p) {
		port = p;
	}

	public void run() {

		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			new ConsoleReader().start();
			while (true) {
				Socket socket = server.accept();
				index++;
				new ServerForClients(socket, this, index).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class ConsoleReader extends Thread {

		public void run() {

			Scanner reader = new Scanner(System.in);
			System.out.println("Enter thread number_message (Example: 2_Hello!)");
			System.out.println("Available threads numbers from 1 to " + index);
			while (reader.hasNextLine()) {
				message = reader.nextLine();
			}
			reader.close();
		}

	}

}