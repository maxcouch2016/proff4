package action04;
 
public abstract class AbstractCalc implements Calcable{
	protected String result = "";
	protected int temp = 0; 
	protected char operation = '0';
	 
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
}
