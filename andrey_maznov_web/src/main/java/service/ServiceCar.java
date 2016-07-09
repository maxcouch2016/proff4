package service;

import java.util.List;

import domain.Car;

public interface ServiceCar {
	public List<Car> getAllCars();
	public void addCarToList(String number, String model);
}
