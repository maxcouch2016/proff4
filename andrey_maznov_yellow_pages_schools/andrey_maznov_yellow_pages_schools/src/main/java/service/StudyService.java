package service;

import java.util.List;

import dao.StudyDao;
import domain.Study;

public class StudyService {

	private StudyDao studyDao = null;

	public StudyService(StudyDao studyDao) {
		this.studyDao = studyDao;
	}

	public void addNewStudy(Study study) {
		studyDao.create(study);
	}

	public void updateStudy(Study study) {
		studyDao.update(study);
	}

	public void deleteStudy(Study study) {
		studyDao.delete(study);		
	}

	public void addNewStudies(Study[] studies) {
		for(Study study:studies){
			studyDao.create(study);
		}
		
	}

	public List<Study> getAllStudies() {
		return studyDao.findAll();
	}

	public List<String> getStudiesNames() {
		return studyDao.findAllStudiesNames();
	}
	
//	public Study getStudyByName(String name) {
//		return studyDao.findStudyByName(name);
//	}
	
}
