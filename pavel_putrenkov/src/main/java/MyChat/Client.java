package MyChat;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConection {
	private int port;
	private String ip;

	public Client(String ip, int port, Consumer<Serializable> onReceiveCallback) {
		super(onReceiveCallback);
		this.ip = ip;
		this.port = port;
	}

	@Override
	protected boolean isServer() {

		return false;
	}

	@Override
	protected String getIP() {

		return ip;
	}

	@Override
	protected int getProt() {

		return port;
	}

}
