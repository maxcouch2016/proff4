package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.CityDao;
import dao.DisciplineDao;
import dao.SchoolDao;
import dao.StudyDao;
import dao.TeacherDao;
import domain.City;
import domain.School;
import domain.Teacher;
import service.CityService;
import service.DisciplineService;
import service.SchoolService;
import service.StudyService;
import service.TeacherService;
import util.HibernateUtil;

@WebServlet("/dataTeacher")
public class DataControllerTeacher extends HttpServlet {

	private SessionFactory factory = HibernateUtil.getSessionFactory();

	private boolean createTeacher(String city, String school, String teacher) {

		CityService cityService = new CityService(new CityDao(factory));
		SchoolService schoolService = new SchoolService(new SchoolDao(factory));
		TeacherService teacherService = new TeacherService(new TeacherDao(factory));

		City dBCity = cityService.getCityByName(city);
		
		School dBSchool = schoolService.getSchoolByNameInCity(school, dBCity);

		Teacher dBTeacher = teacherService.getTeacherByNameInSchool(teacher, dBSchool);

		if (dBTeacher == null) {

			teacherService.addNewTeacher(new Teacher(teacher, dBSchool));
			return true;

		}

		return false;

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String table = req.getParameter("table");
		String city = req.getParameter("city");
		String school = req.getParameter("school");
		String teacher = req.getParameter("teacher");

		System.out.println(table);
		System.out.println(city);
		System.out.println(school);
		System.out.println(teacher);
		
		if (table != null && !table.isEmpty()) {

			boolean res = false;

			JSONObject myJsonObj = new JSONObject();
			
			if (table.equals("teacher") && city != null && !city.isEmpty() && school != null
					&& !school.isEmpty() && teacher != null && !teacher.isEmpty()) {
				
				res = createTeacher(city, school, teacher);
				if (res) {
					
					List<City> cityList = getCities();
					StringBuilder sb = new StringBuilder("<tr><th>Город</th><th>Школа</th><th>Учитель</th></tr>");
					for (City cityElem : cityList) {
						Set<School> schools = cityElem.getSchools();
						if (schools.size() > 0) {
							for (School schoolElem : schools) {
								Set<Teacher> teachers = schoolElem.getTeachers();
								if (teachers.size() > 0) {
									for (Teacher teacherElem : teachers) {
										sb.append("<tr><td>" + cityElem.getName() + "</td><td>" + schoolElem.getName() + "</td><td>" + teacherElem.getName() + "</td></tr>");
									}
								}
								else {
									sb.append("<tr><td>" + cityElem.getName() + "</td><td>" + schoolElem.getName() + "</td><td></td></tr>");
								}
							}
						} else {
							sb.append("<tr><td>" + cityElem.getName() + "</td><td></td><td></td></tr>");
						}
					}
					myJsonObj.append("tableFill", sb.toString());
					
				}
			}

			myJsonObj.append("success", res);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(myJsonObj.toString());

		}

	}

	private List<String> getCitiesNames() {
		CityService service = new CityService(new CityDao(factory));
		List<String> list = service.getCitysNames();

		return list;
	}

	private List<String> getSchoolsNames() {
		SchoolService service = new SchoolService(new SchoolDao(factory));
		List<String> list = service.getSchoolsNames();

		return list;
	}

	private List<String> getTeachersNames() {
		TeacherService service = new TeacherService(new TeacherDao(factory));
		List<String> list = service.getTeachersNames();

		return list;
	}
	
	private List<City> getCities() {
		CityService cityService = new CityService(new CityDao(factory));
		List<City> list = cityService.getAllCities();
		return list;
	}

	private List<String> getSchoolsNamesByCity(String cityName) {
		SchoolService service = new SchoolService(new SchoolDao(factory));
		CityService cityService = new CityService(new CityDao(factory));

		City dBCity = cityService.getCityByName(cityName);
		
		List<String> list = service.getSchoolByCity(dBCity);
		
		return list;
	}

	private List<String> getTeachersNamesBySchool(String cityName, String schoolName) {
		CityService cityService = new CityService(new CityDao(factory));
		SchoolService service = new SchoolService(new SchoolDao(factory));
		TeacherService teacherService = new TeacherService(new TeacherDao(factory));

		City dBCity = cityService.getCityByName(cityName);
		
		School dBSchool = service.getSchoolByNameInCity(schoolName, dBCity);
		
		List<String> list = teacherService.getTeachersBySchool(dBSchool);
		
		return list;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String getType = req.getParameter("getType");
		String cityVal = req.getParameter("cityVal");
		String schoolVal = req.getParameter("schoolVal");

		JSONObject myJsonObj = new JSONObject();

		if (getType != null && !getType.isEmpty() && getType.equals("All")) {
			List<String> citiesList = getCitiesNames();
			List<String> schoolsList = getSchoolsNamesByCity(citiesList.get(citiesList.size() - 1));
			List<String> teachersList = getTeachersNames();

			for (String elem : schoolsList) {
				myJsonObj.append("schools", elem);
			}

			for (String elem : citiesList) {
				myJsonObj.append("cities", elem);
			}
			
			for (String elem : teachersList) {
				myJsonObj.append("teachers", elem);
			}

		} else if (getType != null && !getType.isEmpty() && (getType.equals("SchoolChoose") || getType.equals("SchoolFilter")) && cityVal != null
				&& !cityVal.isEmpty()) {
			List<String> schoolsList = new ArrayList<>();
			if (cityVal.equals("Все города")) {
				schoolsList = getSchoolsNames();
			}
			else {
				schoolsList = getSchoolsNamesByCity(cityVal);
			}

			for (String elem : schoolsList) {
				myJsonObj.append("schools", elem);
			}

		} 
		else if (getType != null && !getType.isEmpty()
				&& getType.equals("TeacherFilter") && schoolVal != null && !schoolVal.isEmpty()) {
			List<String> teachersList = new ArrayList<>();
			if (schoolVal.equals("Все школы")) {
				teachersList = getTeachersNames();
			} else {
				teachersList = getTeachersNamesBySchool(cityVal, schoolVal);
			}

			for (String elem : teachersList) {
				myJsonObj.append("teachers", elem);
			}

		}
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());

	}
}
