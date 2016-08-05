package action17_spring2;

import org.springframework.stereotype.Component;

@Component("app")
class App1 implements Perform{

	@Override
	public int perform() {
		System.out.println("App1.perform");
		return 10;
	}	
}
