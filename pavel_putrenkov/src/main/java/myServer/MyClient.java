package myServer;

import java.nio.channels.SocketChannel;

import myServer.*;
import java.net.InetSocketAddress;

public class MyClient {
	private int portWrite;
	private String ip;
	private int portRead;
	private SocketChannel clientsocketChanel;

	public int getPortWrite() {
		return portWrite;
	}

	public void setPortWrite(int portWrite) {
		this.portWrite = portWrite;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPortRead() {
		return portRead;
	}

	public void setPortRead(int portRead) {
		this.portRead = portRead;
	}

	public MyClient(int portWrite, String ip, int portRead) {
		super();
		this.portWrite = portWrite;
		this.ip = ip;
		this.portRead = portRead;
	}

	public void conectServer() {
		//Server serv= new Server(8080);
		//MyServer sl = new MyServer(3452, "124.0.0");
	//	get
	
//		clientsocketChanel = SocketChannel.open(new InetSocketAddress(portVer, ipVer));

	}

}
