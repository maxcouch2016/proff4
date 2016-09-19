package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeEditController {

	@RequestMapping(value = "/employee_edit", method = RequestMethod.GET)
	public String mainPage(Model model) {
		return "employee_edit";
	}
	
}
