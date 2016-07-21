package action17_task;


public class Company {
private Car car;
private Human director;

public Company(Car car, Human director) {
	super();
	this.car = car;
	this.director = director;
}
public Car getPorshe() {
	return car;
}
public void setPorshe(Car porshe) {
	this.car = porshe;
}
public Human getDirector() {
	return director;
}
public void setDirector(Human director) {
	this.director = director;
}
@Override
public String toString() {
	return "Director [car=" + car + ", Human=" + director + "]";
}

}
