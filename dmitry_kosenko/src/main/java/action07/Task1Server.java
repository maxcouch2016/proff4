package action07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Task1Server {
	public static void main(String[] args) {
		int port = 3238;
		new Server(port).start();
		new Client("localhost", port).start();
		new Client("localhost", port).start();
	}
}

class Server extends Thread {
	private ServerSocket server;
	private final int port;

	public Server(int p) {
		port = p;
	}

	public void run() {

		try {
			server = new ServerSocket(port);
			System.out.println("Server is started!");
			while (true) {
				Socket socket = server.accept();
				new ServerForClients(socket).start();
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
}

class Client extends Thread {
	private String url;
	private int port;
	private Socket socket;

	public Client(String url, int port) {
		this.url = url;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			socket = new Socket(url, port);
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			while (true) {
				String str = dis.readUTF();

				System.out.println("Client receive from srever:" + str);
			}
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}

// Client gotov ****************************************************

class ServerForClients extends Thread {
	private Socket socket;

	public ServerForClients(Socket s) {
		socket = s;

	}

	@Override
	public void run() {

		try {

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("Hello f***en cleint");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

/*
 * 1. Написать "сервер", который умеет многопоточно выполнять задачи: а)
 * Считывать информацию с консоли. Он считывает строку и номер клиента. После
 * считывания, строка отправляется на соответствующий клиент b) Умеет "ждать"
 * подключения нового клиента, при новом подключении клиента, сокет соединения
 * помещается в новый поток для "общения сокета клиента и сокета сервера". с)
 * Класс потока для общения с клиентом (для каждого клиента сервер выделяет
 * новый сокет дял общения) Также написать класс "клиент", который соединяется с
 * сервером. Задача клиента принять строку и вывести ее в формате
 * "Client 1:"+stroka или "Client 2:"+stroka. В Main запуск потока server,
 * client1 и client2.
 */