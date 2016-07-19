package service;

import java.util.List;

import dao.SchoolDao;
import domain.City;
import domain.School;

public class SchoolService {

	private SchoolDao schoolDao = null;

	public SchoolService(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	public void addNewSchool(School school) {
		schoolDao.create(school);
	}

	public void updateSchool(School school) {
		schoolDao.update(school);
	}

	public void deleteSchool(School school) {
		schoolDao.delete(school);		
	}

	public void addNewSchools(School[] schools) {
		for(School school:schools){
			schoolDao.create(school);
		}
		
	}

	public List<School> getAllSchools() {
		return schoolDao.findAll();
	}

	public List<String> getSchoolsNames() {
		return schoolDao.findAllSchoolsNames();
	}
	
	public School getSchoolByName(String name) {
		return schoolDao.findSchoolByName(name);
	}
	
	public List<School> getSchoolsByName(String name) {
		return schoolDao.findSchoolsByName(name);
	}
	
	public School getSchoolByNameInCity(String name, City city) {
		return schoolDao.findSchoolByNameInCity(name, city);
	}
	
	public List<String> getSchoolByCity(City city) {
		return schoolDao.findSchoolByCity(city);
	}
	
}
