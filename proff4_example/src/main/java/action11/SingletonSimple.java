package action11;

public class SingletonSimple {
	private final static SingletonSimple obj = new SingletonSimple();
	
	public static SingletonSimple getInstance(){
		return obj;
	}
	
	private SingletonSimple(){		
	}
}

class Main{
	public void f(){
		SingletonSimple obj = SingletonSimple.getInstance();
	}
}