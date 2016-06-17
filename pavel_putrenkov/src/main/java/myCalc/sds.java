package myCalc;

public class sds {
public static void main(String[] args) {
	String currentText ="452,342342";
	double firstDouble =Double.parseDouble(currentText.replaceAll(" " ,"").replaceAll(",","."));
	System.out.println(firstDouble);
	
	
	
}
}
