package controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import service.UserService;
import service.UserServiceImpl;

@Controller
public class AuthorizationController{
	
	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	@RequestMapping(value = { "/", "/auth" }, method = RequestMethod.GET)
	public String authPageGet(Model model) {
		return "auth";
	}
	
//	@RequestMapping(value= "/login", method = RequestMethod.GET)
	@RequestMapping(value = { "/", "/auth" }, headers="content-type=application/json", method = RequestMethod.GET)
	public String findUser(@RequestParam("username") String foo, Model model) {
//	public String findUser(@ModelAttribute("user") User user){
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/data-context.xml");
//		
//		UserDao dao = (UserDao) context.getBean(UserDaoImpl.class);
//		
//		UserService service = (UserService) context.getBean(UserServiceImpl.class);
//		
//		
//		System.out.println(service.getAll());
		
		System.out.println(userService.getAll());
		
		
		

		
//		JSONObject myJsonObj = new JSONObject();
//		myJsonObj.append("attr1", "value1");
//		//myJsonObj.append("url", "http://www.ukr.net");
//		return myJsonObj.toString();
		
		return "redirect:/departments";
		
	}
	
}
