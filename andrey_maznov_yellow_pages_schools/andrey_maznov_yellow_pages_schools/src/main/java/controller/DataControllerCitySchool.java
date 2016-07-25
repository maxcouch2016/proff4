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

@WebServlet("/dataCitySchool")
public class DataControllerCitySchool extends HttpServlet {

	private SessionFactory factory = HibernateUtil.getSessionFactory();

	private boolean createCity(String city) {

		CityService service = new CityService(new CityDao(factory));

		City dBCity = service.getCityByName(city);

		if (dBCity == null) {

			service.addNewCity(new City(city));
			return true;

		}

		return false;
	}

	private boolean createSchool(String city, String school) {

		SchoolService schoolService = new SchoolService(new SchoolDao(factory));
		CityService cityService = new CityService(new CityDao(factory));

		City dBCity = cityService.getCityByName(city);

		School dBSchool = schoolService.getSchoolByNameInCity(school, dBCity);

		if (dBSchool == null) {

			schoolService.addNewSchool(new School(school, dBCity));
			return true;

		}

		return false;

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String table = req.getParameter("table");
		String city = req.getParameter("city");
		String school = req.getParameter("school");

		if (table != null && !table.isEmpty()) {

			boolean res = false;

			JSONObject myJsonObj = new JSONObject();
			
			if (table.equals("city") && city != null && !city.isEmpty()) {
				res = createCity(city);
			} else if (table.equals("school") && city != null && !city.isEmpty() && school != null
					&& !school.isEmpty()) {
				res = createSchool(city, school);
				if (res) {
					
					List<City> citiesList = getCities();
					StringBuilder sb = new StringBuilder("<tr><th>Город</th><th>Школа</th></tr>");
					for (City cityElem : citiesList) {
						Set<School> schools = cityElem.getSchools();
						if (schools.size() > 0) {
							for (School schoolElem : schools) {
								sb.append("<tr><td>" + cityElem.getName() + "</td><td>" + schoolElem.getName() + "</td></tr>");
							}
						} else {
							sb.append("<tr><td>" + cityElem.getName() + "</td><td></td></tr>");
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String getType = req.getParameter("getType");
		String cityVal = req.getParameter("cityVal");
		
		JSONObject myJsonObj = new JSONObject();

		if (getType != null && !getType.isEmpty() && getType.equals("All")) {
			List<String> citiesList = getCitiesNames();
			List<String> schoolsList = getSchoolsNames();

			for (String elem : schoolsList) {
				myJsonObj.append("schools", elem);
			}

			for (String elem : citiesList) {
				myJsonObj.append("cities", elem);
			}

		} else if (getType != null && !getType.isEmpty() && getType.equals("School") && cityVal != null
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
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());

	}
}
