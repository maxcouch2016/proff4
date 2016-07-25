package action14;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/ajax")
public class AjaxController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject myJsonObj = new JSONObject();
		//StringBuilder sb = new StringBuilder();
		
		// List<Product> products = UserServiceImpl.getAllProduct(); 
		
		myJsonObj.append("pic", "<img src=\"img/main_banner2.jpg\">");
		myJsonObj.append("par2", "456");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(myJsonObj.toString());		
	}
}

