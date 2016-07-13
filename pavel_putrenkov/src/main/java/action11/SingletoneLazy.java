package action11;

public class SingletoneLazy {

	private static SingletoneLazy obj;

	public static SingletoneLazy getInstance() {
		if (obj == null)
			obj = new SingletoneLazy();
		return obj;
	}

	private SingletoneLazy() {
	}

	public static void main(String[] args) {

	}
}
