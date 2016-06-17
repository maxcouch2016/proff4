package action07;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

class MyClient extends Thread {

	private String url;
	private int port;
	private Socket socket;

	public MyClient(String url, int port) {
		this.url = url;
		this.port = port;
	}

	public void run() {
		try {
			socket = new Socket(url, port);
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			while (true) {
				String message = dis.readUTF();
				System.out.println("Client " + message.split("_")[0] + " : " + message.split("_")[1]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
