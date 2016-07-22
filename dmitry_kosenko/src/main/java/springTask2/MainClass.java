package springTask2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("task1Spring/configTask2.xml");
		Start server = (Start)context.getBean("server");
		server.start();
		Start client1 = (Start)context.getBean("client");
		client1.start();
		Start client2 = (Start)context.getBean("client");
		client2.start();

	}

}
