package action17;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		task1();
		task2();
		task3();
		
	}
	
	public static void task3() {
		
		Scanner scan = new Scanner(System.in);
		String s = "";
		
		while(!s.equals("n")) {
			
			System.out.println("Enter first number:");
			s = scan.nextLine();
			int a = Integer.parseInt(s);
			
			System.out.println("Enter second number:");
			s = scan.nextLine();
			int b = Integer.parseInt(s);
			
			System.out.println("Enter operation:");
			s = scan.nextLine();
			String oper = s;
			
			ApplicationContext context = new ClassPathXmlApplicationContext("action17_spring_config/task3_spring_config.xml");
			PrintWriter writer  = (PrintWriter)context.getBean("printWriter");
			
			if (oper.equals("+")) {
				int res = a + b;
				writer.print(Integer.toString(res));
			} else if (oper.equals("-")) {
				int res = a - b;
				writer.print(Integer.toString(res));
			} else if (oper.equals("*")) {
				int res = a * b;
				writer.print(Integer.toString(res));
			} else if (oper.equals("/")) {
				float res = a / b;
				writer.print(Float.toString(res));
			}
			
			System.out.println("Continue? (y/n)");
			
			s = scan.nextLine();
			
		}
		
	}
	
	public static void task2() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("action17_spring_config/task2_spring_config.xml");
		Start server = (Start)context.getBean("server");
		server.start();
		Start client1 = (Start)context.getBean("client");
		client1.start();
		Start client2 = (Start)context.getBean("client");
		client2.start();
		
	}
	
	public static void task1() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("action17_spring_config/task1_spring_config.xml");

		Car car = (Car) context.getBean("idCar");
        System.out.println(car);
		
        Human human = (Human) context.getBean("idHuman");
        System.out.println(human);
        
        Company company = (Company) context.getBean("idCompany");
        System.out.println(company);
		
	}
	
}
