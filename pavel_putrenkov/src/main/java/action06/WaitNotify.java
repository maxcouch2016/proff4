package action06;


public class WaitNotify {
	public void f(){
	
		synchronized (this) {
			try {
				this.wait(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
		//		interrupt();
			}
		}
	}
	public void g(){
		synchronized (this) {
			this.notify();
		}
	}
}
 