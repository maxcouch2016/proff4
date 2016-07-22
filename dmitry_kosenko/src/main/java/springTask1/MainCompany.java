package springTask1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCompany {
	public static void main(String[] args) {
		/*Scanner scan = new Scanner(System.in);
		if (scan.hasNext()) {
			scan.nextLine();
		}*/
		ApplicationContext context = new ClassPathXmlApplicationContext("task1Spring/configFirma.xml");

		Human human = (Human) context.getBean("idHuman");// указываем id нашего
															// bean-а
		System.out.println(human);

		Company company = (Company) context.getBean("idCompany");
		System.out.println(company);
		
		
		Car car = (Car) context.getBean("idCar");
		System.out.println(car);
	}
}
