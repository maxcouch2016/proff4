package controller;


import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
