package MyChat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class NetworkConection {
	private ConnectionThread connThread = new ConnectionThread();
	
	private Consumer<Serializable> onReciveCallback;

	public NetworkConection(Consumer<Serializable> onReceiveCallback) {
		this.onReciveCallback = onReceiveCallback;
		connThread.setDaemon(true);
	}

	public void startConnection() throws Exception {
		connThread.start();
	}

	public void send(Serializable data) throws Exception {
		connThread.out.writeObject(data);
	}

	public void closeConnection() throws Exception {
		connThread.socket.close();
	}

	protected abstract boolean isServer();

	protected abstract String getIP();

	protected abstract int getProt();

	private class ConnectionThread extends Thread {
		private Socket socket;
		private ObjectOutputStream out;
		@Override
		public void run() {
			try (ServerSocket server = isServer() ? new ServerSocket(getProt()) : null;
					Socket soket = isServer() ? server.accept() : new Socket(getIP(), getProt());
					ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(soket.getInputStream())) {
				
				this.socket =soket;
				this.out = out;
				socket.setTcpNoDelay(true);
				while(true){
					Serializable data =(Serializable) in.readObject();
					onReciveCallback.accept(data);
					
					
				}
			} catch (Exception e) {
				onReciveCallback.accept("Conection close");
			}
		}

	}
}
