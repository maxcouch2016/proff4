package action17_spring1;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainHouseLift1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		if(scan.hasNext()){
			scan.nextLine();
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("action17_spring1/config1.xml");

		Lift lift = (Lift) context.getBean("idLift");//указываем id нашего bean-а
        System.out.println(lift);
        
        House house = (House) context.getBean("idHouse");
        System.out.println(house);
	}
}
