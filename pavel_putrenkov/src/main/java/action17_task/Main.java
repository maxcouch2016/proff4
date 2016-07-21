package action17_task;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import action17_spring1.House;
import action17_spring1.Lift;

public class Main {
	public static void main(String[] args) {
	
	
		ApplicationContext context = new ClassPathXmlApplicationContext("action17_test/action17_test.xml");

		Company company = (Company) context.getBean("idcompany");//указываем id нашего bean-а
        System.out.println(company);
        
     
	}
}
