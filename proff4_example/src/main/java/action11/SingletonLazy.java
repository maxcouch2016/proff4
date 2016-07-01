package action11;

public class SingletonLazy {
	private static SingletonLazy obj;
	
	public static SingletonLazy getInstance(){
		if(obj==null) obj = new SingletonLazy();
		return obj;
	}
	
	private SingletonLazy(){		
	}
}
