package controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.User;

@Controller
public class MainController {
	@RequestMapping(value = { "/", "/main" })
	public String mainPage(Model model) {
		return "main";
	}
	@RequestMapping("/cabinet")
	public String cabinetPage(Model model) {
		return "cabinet";
	}
	
	@ResponseBody
	@RequestMapping("/ajax")
	public String ajaxPage(@RequestParam("par") String obj, Model model) {
		System.out.println("ajax controller");
		
		System.out.println("obj="+obj);
		
		
		JSONObject myJsonObj = new JSONObject();
		myJsonObj.append("attr1", "value1");
		//myJsonObj.append("url", "http://www.ukr.net");
		return myJsonObj.toString();

	}
	@ResponseBody
	@RequestMapping("/ajaxPageContent")
	public String ajaxPage1(@RequestParam("count") int count, Model model) {
		System.out.println("ajax controller");
		
		
		List<User> users = null ; // serviseUserImpl.getListUsersByLimit(10, count)
		//(10, 1); 
		// (10, 2 )
		// (10, 3)
		
		int countUsers = 0; // serviseUserImpl.getCountAllUsers
		int countPages = (int)Math.round(countUsers/10 + 0.5);
		
		StringBuilder sTable = new StringBuilder();
		for(User us: users) sTable.append(us.toTableString());
		
		JSONObject myJsonObj = new JSONObject();
		myJsonObj.append("tableUsers", sTable.toString());
		myJsonObj.append("countPages", countPages);
		
		//myJsonObj.append("url", "http://www.ukr.net");
		return myJsonObj.toString();

	}

}
