package controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

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

@Controller
public class MainPageReaderController {

	@Autowired(required=true)
	private WorkerService workerService;
	
	
	@Autowired
	private HttpServletRequest req;
	

	@RequestMapping(value={"/main_page_reader"}, method = RequestMethod.GET)
	public String showMainPage(Map<String, Object> model){
		
		req.setAttribute("pageCount", workerService.getPageCount());
		
		return "main_page_reader";		
	}
	
	@ResponseBody
	@RequestMapping("/returnValues")
	public String returnValues(@RequestParam("number") int count, Model model) {

		
		List <Worker> workers = workerService.getAllWorkers();
		
		int leftBorder = count * 40;
		int rightBorder = leftBorder + 40;
		
		
		StringBuilder workersTable = new StringBuilder();
		
		try{
		for (int i=leftBorder; i<rightBorder; i++){
			
			Worker worker = workers.get(i);
			workersTable.append(worker.toTableString());
		}
		}catch(Exception e){}
		
		JSONObject myJsonObj = new JSONObject();
		
		myJsonObj.append("tableWorkers", workersTable.toString());
		
		return myJsonObj.toString();

	}
	
	@ResponseBody
	@RequestMapping("/findWorkers")
	public String findWorkers(@RequestParam("name") String name, Model model) {
		
		String nameOrSurname = name.trim();
		
		List<String> stringParts = new ArrayList<String>();
		
		Scanner scan = new Scanner(nameOrSurname);
		
		while (scan.hasNext()){
			String part = scan.next();
			stringParts.add(part);
		}
		scan.close();
		
		List <Worker> workers = workerService.getAllWorkers();
		
		StringBuilder workersTable = new StringBuilder();
		
		for (int i=0; i< workers.size(); i++){
			Worker worker = workers.get(i);
			
			for(int j = 0; j < stringParts.size(); j++){
				if (worker.getName().startsWith(stringParts.get(j)) || worker.getLastname().startsWith(stringParts.get(j))
						|| worker.getName().endsWith(stringParts.get(j)) || worker.getLastname().endsWith(stringParts.get(j)) ){
					workersTable.append(worker.toTableString());
				}
			}
			
			
			
		}
		
		JSONObject myJsonObj = new JSONObject();
		
		myJsonObj.append("foundWorkers", workersTable.toString());
		System.out.println(myJsonObj.toString());
		return myJsonObj.toString();

	}
	
	
	
	
	
}
