package hwWeek3;

public class CalcProcessor extends Thread{
	
	private int val1;
	private int val2;
	private final String ByZero = "Error Divide By Zero";
	private char operation = '0';
	private boolean needCalc;
	private String result;
	private boolean needRes;
	
	public boolean isNeedCalc() {
		return needCalc;
	}
	
	public void setNeedCalc(boolean needCalc) {
		this.needCalc = needCalc;
	}
	
	public void setOperation(char operation) {
		this.operation = operation;
	}
	
	public char getOperation() {
		return operation;
	}
	
	public int getVal1() {
		return val1;
	}
	
	public int getVal2() {
		return val2;
	}
	
	public void setVal1(int val1) {
		this.val1 = val1;
	}
	
	public void setVal2(int val2) {
		this.val2 = val2;
	}
	
	public boolean isNeedRes() {
		return needRes;
	}
	
	public void setNeedRes(boolean needRes) {
		this.needRes = needRes;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void run() {
		while (!isInterrupted()) {
			
			if (needCalc) {
				synchronized (this) {
					if (operation == '-') {
						result = Integer.toString(val1 - val2);
						setFlags();
					} else if (operation == '+') {
						result = Integer.toString(val1 + val2);
						setFlags();
					} else if (operation == '*') {
						result = Integer.toString(val1 * val2);
						setFlags();
					} else if (operation == '/' && val2 == 0) {
						result = ByZero;
						setFlags();
					} else if (operation == '/') {
						result = Float.toString((float) val1 / (float) val2);
						setFlags();
					}
				}
			}
		}
	}
	
	private void setFlags() {
		needCalc = false;
		needRes = true;
	}
	
}