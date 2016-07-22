package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value={"/", "/home"}, method = RequestMethod.GET)
	public String showMainPage(Map<String, Object> model){
		return "home";		
	}
	@RequestMapping("/users")
	public String showListUsersPage(Map<String, Object> model){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("name1", "name2", "name3"));
		model.put("names", list);
		return "users";
		
	}
}
