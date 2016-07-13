package service;

import java.util.ArrayList;
import java.util.List;

import domain.Car;

public class ServiceCarImpl implements ServiceCar{

	private List<Car> list = new ArrayList<>();
	
	@Override
	public List<Car> getAllCars() {
		return list;
	}
	
	@Override
	public void addCarToList(String number, String model) {
		list.add(new Car(number, model));
	}

}
