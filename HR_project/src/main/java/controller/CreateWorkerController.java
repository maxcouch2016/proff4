package controller;


import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Worker;
import service.WorkerService;
import tools.Validator;

@Controller
public class CreateWorkerController {

	private WorkerService workerService;
	
	@Autowired(required = true)
	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	@RequestMapping(value={"/create_worker"}, method = RequestMethod.GET)
	public String showMainPage(Map<String, Object> model){
		return "create_worker_page";
	}
	
	@ResponseBody
	@RequestMapping("/create_worker")
	public String ajaxPage(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName ,
			@RequestParam("salary") String salary , @RequestParam("birthDate") String birthDate , 
			@RequestParam("status") String status, @RequestParam("department") String department ,Model model) {
		
		System.out.println("Input data: " + firstName + " " + " " + lastName + " " + salary + " "  + birthDate + " " + status +" " +department);
		
		Validator validator = new Validator();
		StringBuilder answer = new StringBuilder();
		JSONObject myJsonObj = new JSONObject();
		
		
		if (validator.validateName(firstName) && validator.validateName(lastName)){
			firstName = firstName.toLowerCase();
			firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
			
			lastName = lastName.toLowerCase();
			lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
		} else {
			answer.append("First name field or last name field must contain only one word! ");
		}
		if (validator.validateSalary(salary)==0){
			answer.append(" Salary must contain only numbers and more than zero! ");
		} 
		if (validator.validateDate(birthDate).equals("")){
			answer.append(" Date must contain only numbers and / ");
		}
		answer.append("!");
		
		if (answer.toString().equals("!")){
			int state = 0;
			if (status.equals("Active")) state = 1;
			
			workerService.addNewWorker(new Worker (firstName , lastName , Double.parseDouble(salary) , validator.validateDate(birthDate) , state , department));
			System.out.println("Worker added succesfuly");
		}
		
		
		
		myJsonObj.append("answer", answer);
		return myJsonObj.toString();
	}
	
}
