package action06;

import java.util.Scanner;

public class MyScannerExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		if(scan.hasNextInt()){
			int k1 = scan.nextInt();
			System.out.println(k1);
		}
		if(scan.hasNextInt()){
			System.out.println("Input number2");
			int k2 = scan.nextInt();
			System.out.println(k2);
		}
	}
}
