package controller;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import service.WorkerService;

@Controller
public class MainPageModeratorController {

	@Autowired(required=true)
	private WorkerService workerService;
	
	
	
	@Autowired
	private HttpServletRequest req;
	

	@RequestMapping(value={"/main_page_moderator"}, method = RequestMethod.GET)
	public String showMainPage(Map<String, Object> model){
		
		req.setAttribute("pageCount", workerService.getPageCount());
		
		return "main_page_moderator";		
	}
	

}
