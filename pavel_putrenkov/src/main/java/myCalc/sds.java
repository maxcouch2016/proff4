package myCalc;



public class sds {
public static void main(String[] args) throws Exception {
	String currentText ="452,342342";
	double firstDouble =Double.parseDouble(currentText.replaceAll(" " ,"").replaceAll(",","."));
	System.out.println(firstDouble);
	String c = "sdsd";
	char txt = ' ';
//	int a =c.charAt(txt);
//	System.out.println(a);
	int numB=3;
	int k=4;
	numB=numB/k;
//	String numg=String.format("%.3f", numB);
//	System.out.println(numg);
	while(true){
	int bytein=System.in.read();
	System.out.println(bytein);
}
}
}