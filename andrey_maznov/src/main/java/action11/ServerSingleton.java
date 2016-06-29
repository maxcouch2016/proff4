package action11;

public class ServerSingleton {

	private static final ServerSingleton instance = new ServerSingleton();
	
	public static ServerSingleton getInstance() {
		return instance;
	}
	
	private ServerSingleton() {
	}
	
}
