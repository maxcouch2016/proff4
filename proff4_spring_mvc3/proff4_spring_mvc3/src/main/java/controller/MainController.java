package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
