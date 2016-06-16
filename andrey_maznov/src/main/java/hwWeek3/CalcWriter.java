package hwWeek3;

public class CalcWriter extends Thread{
	
	private CalcProcessor processor;

	public CalcWriter(CalcProcessor processor) {
		this.processor = processor;
	}
	
	public void run() {
		while (!isInterrupted()) {
			if (processor.isNeedRes()) {
				synchronized (processor) {
					System.out.println(processor.getVal1() + " " + processor.getOperation() + 
							" " + processor.getVal2() + " = " + processor.getResult());
					processor.setNeedRes(false);
					processor.setResult("");
					processor.setVal1(0);
					processor.setVal2(0);
					processor.setOperation('0');
				}
			}
		}
	}
}
