package action11;


public class Car {

	private String color;
	private String number;
	private String marka;
	
	public Car(String color, String number, String marka) {
		this.color = color;
		this.number = number;
		this.marka = marka;
	}
	
	public Car() {
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", number=" + number + ", marka=" + marka + "]";
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}
	
}
