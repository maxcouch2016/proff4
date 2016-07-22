package springTask3;

import java.io.FileWriter;
import java.io.IOException;

public class PrintWriter {

	private boolean debug;
	
	public void print(String str) {
		
		System.out.println(str);
		if (debug) {
			try {
				// запись логов
				FileWriter writer = new FileWriter("src\\main\\resourse\\logs.txt", true);
				
				writer.write(str + System.lineSeparator());
				
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public String toString() {
		return "PrintWriter [debug=" + debug + "]";
	}
	
	public PrintWriter(boolean debug) {
		this.debug = debug;
	}

	public PrintWriter() {
	}
	
	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}


	
}