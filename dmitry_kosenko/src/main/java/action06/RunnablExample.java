package action06;

public class RunnablExample {
	public static void main(String[] args) {
		M obj1 = new M();
		Thread obj = new Thread(obj1);
		obj.start();
		
				
	}
}

class M implements Runnable{
	public void run(){
		
	}
}
