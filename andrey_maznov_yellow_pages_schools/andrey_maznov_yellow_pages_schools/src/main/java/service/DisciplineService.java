package service;

import java.util.List;

import dao.DisciplineDao;
import domain.Discipline;

public class DisciplineService {

	private DisciplineDao disciplineDao = null;

	public DisciplineService(DisciplineDao disciplineDao) {
		this.disciplineDao = disciplineDao;
	}

	public void addNewDiscipline(Discipline discipline) {
		disciplineDao.create(discipline);
	}

	public void updateDiscipline(Discipline discipline) {
		disciplineDao.update(discipline);
	}

	public void deleteDiscipline(Discipline discipline) {
		disciplineDao.delete(discipline);		
	}

	public void addNewDisciplines(Discipline[] disciplines) {
		for(Discipline discipline:disciplines){
			disciplineDao.create(discipline);
		}
		
	}

	public List<Discipline> getAllDisciplines() {
		return disciplineDao.findAll();
	}

	public List<String> getDisciplinesNames() {
		return disciplineDao.findAllDisciplinesNames();
	}
	
//	public Discipline getDisciplineByName(String name) {
//		return disciplineDao.findDisciplineByName(name);
//	}
	
}
