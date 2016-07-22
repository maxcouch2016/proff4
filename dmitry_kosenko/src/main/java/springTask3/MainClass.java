package springTask3;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Boolean test = true;
		ApplicationContext context = new ClassPathXmlApplicationContext("task1Spring/configTask3.xml");
		PrintWriter writer  = (PrintWriter)context.getBean("printWriter");
		
		
		while(test){
		System.out.println("Введите первое число:");
		int first = scn.nextInt();
		System.out.println("Введите второе число:");
		int second = scn.nextInt();
		System.out.println("Введите вариант операции");
		String key = scn.next();
		int res;
		
	
		
		switch (key) {
		case "+": res = first + second; writer.print(Integer.toString(res));  break;
		case "-": res = first - second; writer.print(Integer.toString(res));  break;
		case "*": res = first * second; writer.print(Integer.toString(res));  break;
		case "/": res = first / second; writer.print(Integer.toString(res));  break;
		}
		System.out.println("Continue? (y/n)");
		
		String var = scn.next();
		if(var.equals("n")) test = false;
		
		
		}
	}

}
