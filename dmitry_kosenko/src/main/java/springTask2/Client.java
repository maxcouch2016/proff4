package springTask2;

import org.springframework.stereotype.Component;

@Component("client")
public class Client implements Start{

	private String name;

	public void start() {
		System.out.println("Client was started");
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client(String name) {
		this.name = name;
	}
	
	public Client() {
	}
	
	
	
}
