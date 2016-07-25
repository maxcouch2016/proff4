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

@WebServlet("/tableCitySchool")
public class TableControllerCitySchool extends HttpServlet {

	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	private List<City> getCities() {
		CityService cityService = new CityService(new CityDao(factory));
		List<City> list = cityService.getAllCities();
		return list;
	}
	
	private List<School> getSchoolsByName(String name) {
		SchoolService schoolService = new SchoolService(new SchoolDao(factory));
		List<School> list = schoolService.getSchoolsByName(name);
		return list;
	}
	
	private City getCityByName(String name) {
		CityService cityService = new CityService(new CityDao(factory));
		City city = cityService.getCityByName(name);
		return city;
	}
	
	private School getSchoolByCityAndName(String name, City city) {
		SchoolService schoolService = new SchoolService(new SchoolDao(factory));
		School school = schoolService.getSchoolByNameInCity(name, city);
		return school;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tableName = req.getParameter("tableName");
		String chooseCity = req.getParameter("chooseCity");
		String chooseSchool = req.getParameter("chooseSchool");
		
		JSONObject myJsonObj = new JSONObject();

		if (tableName != null && !tableName.isEmpty()) {
		
			StringBuilder sb = new StringBuilder("<tr><th>Город</th><th>Школа</th></tr>");

			if (!chooseCity.equals("undefined") && !chooseCity.isEmpty() && !chooseSchool.equals("undefined") && !chooseSchool.isEmpty()) {

				if (chooseCity.equals("Все города") && chooseSchool.equals("Все школы")) {
					List<City> citiesList = getCities();

					for (City city : citiesList) {
						Set<School> schools = city.getSchools();
						if (schools.size() > 0) {
							for (School school : schools) {
								sb.append("<tr><td>" + city.getName() + "</td><td>" + school.getName() + "</td></tr>");
							}
						} else {
							sb.append("<tr><td>" + city.getName() + "</td><td></td></tr>");
						}
					}
				} else if (chooseCity.equals("Все города") && !chooseSchool.equals("Все школы")) {

					List<School> list = getSchoolsByName(chooseSchool);
					for (School school : list) {
						sb.append("<tr><td>" + school.getCity().getName() + "</td><td>" + school.getName() + "</td></tr>");
					}
					
				} else if (!chooseCity.equals("Все города") && chooseSchool.equals("Все школы")) {
					
					City city = getCityByName(chooseCity);
					Set<School> set = city.getSchools();
					for (School school : set) {
						sb.append("<tr><td>" + city.getName() + "</td><td>" + school.getName() + "</td></tr>");
					}
					
				} else {

					City city = getCityByName(chooseCity);
					School school = getSchoolByCityAndName(chooseSchool, city);
					sb.append("<tr><td>" + city.getName() + "</td><td>" + school.getName() + "</td></tr>");
					
				}
				
			} else {

				List<City> citiesList = getCities();

				for (City city : citiesList) {
					Set<School> schools = city.getSchools();
					if (schools.size() > 0) {
						for (School school : schools) {
							sb.append("<tr><td>" + city.getName() + "</td><td>" + school.getName() + "</td></tr>");
						}
					} else {
						sb.append("<tr><td>" + city.getName() + "</td><td></td></tr>");
					}
				}
			}
			myJsonObj.append("tableFill", sb.toString());
		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());

	}
}
