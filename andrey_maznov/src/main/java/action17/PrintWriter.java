package action17;

import java.io.FileWriter;
import java.io.IOException;

public class PrintWriter {

	private boolean debug;
	
	public void print(String str) {
		
		System.out.println(str);
		if (debug) {
			try {
				FileWriter writer = new FileWriter("src\\main\\resources\\logs.txt", true);
				writer.write(str + System.lineSeparator());
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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

	@Override
	public String toString() {
		return "PrintWriter [debug=" + debug + "]";
	}
	
}
