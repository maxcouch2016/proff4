package service;

import java.util.List;

import dao.TeacherDao;
import domain.City;
import domain.School;
import domain.Teacher;

public class TeacherService {

	private TeacherDao teacherDao = null;

	public TeacherService(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void addNewTeacher(Teacher teacher) {
		teacherDao.create(teacher);
	}

	public void updateTeacher(Teacher teacher) {
		teacherDao.update(teacher);
	}

	public void deleteTeacher(Teacher teacher) {
		teacherDao.delete(teacher);		
	}

	public void addNewTeachers(Teacher[] teachers) {
		for(Teacher teacher:teachers){
			teacherDao.create(teacher);
		}
		
	}

	public List<Teacher> getAllTeachers() {
		return teacherDao.findAll();
	}

	public List<String> getTeachersNames() {
		return teacherDao.findAllTeachersNames();
	}
	
	public List<String> getTeachersBySchool(School school) {
		return teacherDao.findTeacherBySchool(school);
	}
	
	public Teacher getTeacherByNameInSchool(String teacher, School school) {
		return teacherDao.findTeacherByNameInSchool(teacher, school);
	}
	
}
