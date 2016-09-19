package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.User;

@RestController
public class UserController {

	@RequestMapping(value = "/find_user")
	public User findUser(@RequestBody String username, String password) {
		
		System.out.println(username);
		System.out.println(password);
		
		return null;
	}
	
}
