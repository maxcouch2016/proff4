package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		
		if(login!=null && login.equals(pass)){
			req.setAttribute("nameUser", "Pupkin");
			Cookie cookie1 = new Cookie("cookLogin",login);
			cookie1.setMaxAge(3600);
			cookie1.setHttpOnly(true);
			resp.addCookie(cookie1);
			//
			Cookie cookie2 = new Cookie("cookPass",pass);
			cookie2.setMaxAge(3600);
			cookie2.setHttpOnly(true);
			resp.addCookie(cookie2);

		} else {
			Cookie[] arrCook =  req.getCookies();
			for(Cookie cook:arrCook){
				if(cook.getName().equals("cookPass")){
					req.setAttribute("cookPass", cook.getValue());
				}
				if(cook.getName().equals("cookLogin")){
					req.setAttribute("cookLogin", cook.getValue());
				}
				
			}
					
			req.setAttribute("cLogin", "");
		}
		String logout = req.getParameter("logout");
		if("logout".equals(logout))req.setAttribute("nameUser", "");
		req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
	}
}
