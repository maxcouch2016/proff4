package action07;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerForClients extends Thread {
	private Socket socket;
	private MyServer server;
	private int index;

	public ServerForClients(Socket s, MyServer myServ, int index) {
		this.socket = s;
		this.server = myServ;
		this.index = index;
	}

	@Override
	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			while (true) {
				if (server.getMessage() != null && !server.getMessage().isEmpty()) {
					if (server.getMessage().split("_")[0].equals(Integer.toString(index))) {
						dos.writeUTF(server.getMessage());
						server.setMessage("");

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
