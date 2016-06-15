package action04;

public class MyCalc extends AbstractCalc{

	private boolean tempSet;
	private boolean isResult;
	
	public static void main(String[] args) {
		MyCalc calc = new MyCalc();
		String s = "5*2=";
		char[] array = s.toCharArray();
		for (char c : array) {
			calc.inChar(c);
		}
		calc.printResult();
		s = "5+002=";
		array = s.toCharArray();
		for (char c : array) {
			calc.inChar(c);
		}
		calc.printResult();
		s = "0005+=";
		array = s.toCharArray();
		for (char c : array) {
			calc.inChar(c);
		}
		calc.printResult();
		s = "0005/0=";
		array = s.toCharArray();
		for (char c : array) {
			calc.inChar(c);
		}
		calc.printResult();
		s = "0000012/4=";
		array = s.toCharArray();
		for (char c : array) {
			calc.inChar(c);
		}
		calc.printResult();
		s = "011000-010000=";
		array = s.toCharArray();
		for (char c : array) {
			calc.inChar(c);
		}
		calc.printResult();
	}
	
	@Override
	public void inChar(char p) {
		
		if (isResult) {
			setOperation('0');
			setTemp(0);
			setResult("");
			tempSet = !tempSet;
			isResult = !isResult;
		}
		
		if (p == '=' && !getResult().isEmpty()) {
			if (!tempSet) {
				setTemp(Integer.parseInt(getResult()));
			}
			if (getOperation() == '-') {
				setResult(Integer.toString(Integer.parseInt(getResult()) - getTemp()));
			} else if (getOperation() == '+') {
				setResult(Integer.toString(Integer.parseInt(getResult()) + getTemp()));
			} else if (getOperation() == '*') {
				setResult(Integer.toString(Integer.parseInt(getResult()) * getTemp()));
			} else if (getOperation() == '/' && getTemp() == 0) {
				setResult(Calcable.ByZero);
			}
			else if (getOperation() == '/') {
				setResult(Integer.toString(Integer.parseInt(getResult()) / getTemp()));
			}
			isResult = !isResult;
		}
		else if ((p == '-' || p == '+' || p == '*' || p == '/') && !getResult().isEmpty()) {
			setOperation(p);
		}
		else if(p >= '0' && p <= '9') {
			if (getOperation() == '0') {
				setResult(Integer.toString(Integer.parseInt(getResult() + p)));
			}
			else {
				setTemp(Integer.parseInt(Integer.toString(getTemp()) + Character.toString(p)));
				tempSet = true;
			}
		}
		
	}
	
}
