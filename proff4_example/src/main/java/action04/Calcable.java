package action04;

public interface Calcable {
	public static final String ByZero = "Error Divide By Zero";
	
	public String getResult();
	public void inChar(char p);
	
	public default void printResult(){
		System.out.println(getResult());
	}
	
}
