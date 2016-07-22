package springTask2;

import org.springframework.stereotype.Component;

@Component("server")
public class Server implements Start{

	private String name;
	public void start() {
		System.out.println("Server was started");
	}
	@Override
	public String toString() {
		return "Server [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Server(String name) {
		this.name = name;
	}
	
	public Server() {
	}
	
	
	
}
