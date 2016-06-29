package action11;

public class CarBuilderExample {
	public static void main(String[] args) {
		Car car1 = new BuilderCar().setColor("Black")
				.setNumber("AA 111").build();
		System.out.println(car1);

		
		BuilderCar config = new BuilderCar().setColor("Red");
		Car car2 = config.setNumber("2222").setMarka("KIA").build();
		
		System.out.println(car2); 		
	}	
}
class Car{
	private String color;
	private String marka;
	private String number;
	
	public Car() {
	}
	public Car(String color, String marka, String number) {
		this.color = color;
		this.marka = marka;
		this.number = number;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public void setNumber(String number) {
		this.number = number;
	}	
}

class BuilderCar{
	private Car car;
	public BuilderCar(){
		car = new Car();
	}
	public BuilderCar setColor(String string) {
		car.setColor(string);
		return this;
	}
	public BuilderCar setMarka(String string) {
		car.setMarka(string);
		return this;
	}
	public BuilderCar setNumber(String string) {
		car.setNumber(string);
		return this;
	}
	public Car build() {
		return car;
	}	
}

class BuilderCar1{
	private String color;
	private String marka;
	private String number;
	public BuilderCar1(){
	}
	public BuilderCar1 setColor(String string) {
		color = string;
		return this;
	}
	public BuilderCar1 setMarka(String string) {
		marka = string;
		return this;
	}
	public BuilderCar1 setNumber(String string) {
		number = string;
		return this;
	}
	public Car build() {
		return new Car(color, marka, number);
	}	
}