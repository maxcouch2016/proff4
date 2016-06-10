package action04;

public class MiniCalc {
	public int multiply(int a, int b){
		int res = (a/2) * 2 * b;
		return res; 
	}
	public int multiplyInt(int a, int b){
		int res = (a/2) * 2 * b;
		return new Integer(res);
	}
} 
