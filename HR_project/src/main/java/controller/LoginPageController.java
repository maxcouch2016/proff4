package controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.User;
import service.UserService;




@Controller
public class LoginPageController {

	private UserService userService;

	
	@Autowired(required = true)
	public void setUserService(UserService us) {
		this.userService = us;
	}
	
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public String showMainPage(Map<String, Object> model){
		return "login_page";		
	}
		
	@ResponseBody
	@RequestMapping("/login")
	public String loginValidation(@RequestParam("login") String login,@RequestParam("password") String password, Model model) {
		
	
	System.out.println("name = " + login + " password = " + password);
		
		
		List<User> users = userService.getAllUsers();
		
		User currentUser;
		JSONObject myJsonObj = new JSONObject();
		String url = "";
		
		for(int i = 0; i < users.size() ; i++){
			currentUser = (User) users.get(i);
		if (currentUser.getLogin().equals(login) && currentUser.getPassword().equals(password)){
				if (currentUser.getRole() == 0){
					url = "main_page_reader";
				} else {
					url = "main_page_moderator";
				}
				break;
			}
		}
		
		myJsonObj.append("url", url);
		return myJsonObj.toString();
	}
}
