package hwWeek3;

import java.util.Scanner;

public class CalcReader extends Thread{
	
	private CalcProcessor processor;
	private Scanner reader;
	private CalcWriter writer;
	
	public CalcReader(CalcProcessor processor, CalcWriter writer) {
		this.processor = processor;
		this.writer = writer;
		reader = new Scanner(System.in);
	}
	
	public void run() {
		String s = "";
		while (reader.hasNextLine() && !(s = reader.nextLine()).equals("quit")) {
			for (char c : s.toCharArray()) {
				if (!processor.isNeedCalc() && !processor.isNeedRes()) {
					synchronized (processor) {
						if (c == '=') {
							processor.setNeedCalc(true);
						} else if ((c == '-' || c == '+' || c == '*' || c == '/')) {
							processor.setOperation(c);
						} else if (c >= '0' && c <= '9') {
							if (processor.getOperation() == '0') {
								processor.setVal1(Integer.parseInt(Integer.toString(processor.getVal1()) + c));
							} else {
								processor.setVal2(Integer.parseInt(Integer.toString(processor.getVal2()) + c));
							}
						}
					}
				}
			}
		}
		processor.interrupt();
		writer.interrupt();
	}
}
