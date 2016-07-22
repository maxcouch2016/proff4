package springTask1;

public class Car {
	private Human human;
	private String namePasager;
	public Car(Human human, String name) {
		super();
		this.human = human;
		this.namePasager = name;
	}
	public Human getHuman() {
		return human;
	}
	public void setHuman(Human human) {
		this.human = human;
	}
	public String getNamePasager() {
		return namePasager;
	}
	public void setName(String name) {
		this.namePasager = name;
	}
	@Override
	public String toString() {
		return "Car [Катается= " + human + ", Марка= " + namePasager + "]";
	}
	
}
