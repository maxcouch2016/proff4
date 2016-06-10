package action06;

public class ThreadExampleAction06 {
	public static void main(String[] args) throws Exception {
		MyThreadEx obj1 = new MyThreadEx("name1");
		MyThreadEx obj2 = new MyThreadEx("\tname2");

		obj1.start();
		obj2.start();
		//obj1.stop();
		//obj1.interrupt();
		//obj2.setPriority(Thread.NORM_PRIORITY+2);
		//obj1.isDaemon();
		obj1.join();
		
		System.out.println("\t\tMain end");
	}
}

class MyThreadEx extends Thread {

	private String name;

	public MyThreadEx(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2000; i++) {
			if (isInterrupted()) {
				break;
			}
			System.out.println(name + "_" + i);
		}
		System.out.println(name+"_end");
	}
}
