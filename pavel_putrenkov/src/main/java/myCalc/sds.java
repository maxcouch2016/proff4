package myCalc;



public class sds {
public static void main(String[] args) {
	String currentText ="452,342342";
	double firstDouble =Double.parseDouble(currentText.replaceAll(" " ,"").replaceAll(",","."));
	System.out.println(firstDouble);
	String c = "sdsd";
	char txt = ' ';
	int a =c.charAt(txt);
	System.out.println(a);
}
}
