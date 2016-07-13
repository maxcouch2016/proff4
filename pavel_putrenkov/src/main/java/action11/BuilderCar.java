package action11;

public class BuilderCar {

	private Car car;

	public BuilderCar() {
		car = new Car();
	}
	
	public BuilderCar setColor(String color) {
		car.setColor(color);
		return this;
	}

	public BuilderCar setNumber(String number) {
		car.setNumber(number);
		return this;
	}
	
	public BuilderCar setMarka(String marka) {
		car.setMarka(marka);
		return this;
	}
	
	public Car build() {
		return car;
	}
	
}