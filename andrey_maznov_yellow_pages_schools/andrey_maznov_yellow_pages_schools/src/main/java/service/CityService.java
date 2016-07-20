package service;

import java.util.List;

import dao.CityDao;
import domain.City;

public class CityService {

	private CityDao cityDao = null;

	public CityService(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public void addNewCity(City city) {
		cityDao.create(city);
	}

	public void updateCity(City city) {
		cityDao.update(city);
	}

	public void deleteCity(City city) {
		cityDao.delete(city);		
	}

	public void addNewCities(City[] cities) {
		for(City city:cities){
			cityDao.create(city);
		}
		
	}

	public List<City> getAllCities() {
		return cityDao.findAll();
	}

	public City getCityByName(String name) {
		return cityDao.findCityByName(name);
	}
	
	public List<String> getCitysNames() {
		return cityDao.findAllCityNames();
	}
	
}
