package hwWeek3;

public class CalcMainer extends Thread{
	
	public void run() {
		
		CalcProcessor processor = new CalcProcessor();
		CalcWriter writer = new CalcWriter(processor);
		CalcReader reader = new CalcReader(processor, writer);
		processor.start();
		reader.start();
		writer.start();
	}
	
}
