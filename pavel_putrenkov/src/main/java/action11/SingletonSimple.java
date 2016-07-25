package action11;

public class SingletonSimple {
	private final static SingletonSimple obj = new SingletonSimple();

	public static SingletonSimple getInstance() {
		return obj;
	}

	public static void main(String[] args) {

		SingletonSimple obj = new SingletonSimple();

	}

}
