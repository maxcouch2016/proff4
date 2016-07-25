package action17;

public class Human {

	private String name;
	private Car car;
	
	public Human() {
	}

	public Human(Car car, String name) {
		this.car = car;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", car=" + car + "]";
	}
	
}
