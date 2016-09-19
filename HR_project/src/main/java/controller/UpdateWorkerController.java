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

import domain.Worker;
import service.WorkerService;
import tools.Validator;

@Controller
public class UpdateWorkerController {
	
private WorkerService workerService;
	
	@Autowired(required = true)
	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	@RequestMapping(value={"/update_worker"}, method = RequestMethod.GET)
	public String showMainPage(Map<String, Object> model){
		return "update_worker_page";		
	}
	
	@ResponseBody
	@RequestMapping("/search")
	public String searchById(@RequestParam("id") String id, Model model) {
		
		System.out.println(id);
		
		List <Worker> workers = workerService.getAllWorkers();
		
		JSONObject myJsonObj = new JSONObject();
	
		Long currentId;
		for(int i = 0; i < workers.size(); i++){
			
			currentId = workers.get(i).getWorker_id();
			if(Long.toString(currentId).equals(id)){
				
				myJsonObj.append("answer", "OK");
				myJsonObj.append("workerid", workers.get(i).getWorker_id());
				myJsonObj.append("firstname", workers.get(i).getName());
				myJsonObj.append("lastname", workers.get(i).getLastname());
				myJsonObj.append("salary", Double.toString(workers.get(i).getSalary()));
				myJsonObj.append("date", workers.get(i).getBirthdate());
				System.out.println("Ok =" + myJsonObj.toString());
				return myJsonObj.toString();
				
			}
		}
		
		return myJsonObj.append("answer", "FALSE").toString();
	}


@ResponseBody
@RequestMapping("/update")
public String searchById(@RequestParam("id") String id, @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName ,
		@RequestParam("salary") String salary , @RequestParam("birthDate") String birthDate , 
		@RequestParam("status") String status, @RequestParam("department") String department ,Model model) {
	System.out.println(firstName +" " + lastName + " " + Double.parseDouble(salary) + " " + birthDate + " " +  status +" "+  department);
	JSONObject myJsonObj = new JSONObject();
	
	if (id.equals("Invalid id")){
		return myJsonObj.append("answer", "FALSE").toString();
	}
	
	Validator validator = new Validator();
	StringBuilder answer = new StringBuilder();
	
	
	
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
		workerService.updateWorkerById(id, firstName, lastName, salary, validator.validateDate(birthDate), state, department);
		System.out.println(firstName +" " + lastName + " " + Double.parseDouble(salary) + " " + validator.validateDate(birthDate) + " " +  state +" "+  department);
	}
	
	
	
	myJsonObj.append("answer", "OK");
	return myJsonObj.toString();
	
	}
}