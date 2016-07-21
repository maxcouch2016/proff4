package action17;

public class Company {

	private String name;
	private Car car;
	private Human director;
	
	public Company() {
	}

	public Company(Car car, Human director, String name) {
		this.car = car;
		this.director = director;
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

	public Human getDirector() {
		return director;
	}

	public void setDirector(Human director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", car=" + car + ", director=" + director + "]";
	}
	
}
