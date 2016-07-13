package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import dao.UserDao;
import domain.User;
import service.UserService;
import util.HibernateUtil;

@WebServlet("/main")
public class MainController extends HttpServlet {
	
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserService service = new UserService(new UserDao(factory));
		
		User user = service.getUserByLoginPassword(req.getParameter("login"), req.getParameter("pass"));
		
		if (user != null) {
			req.getSession().setAttribute("user", user);
		    resp.sendRedirect("content");
		}
		else {
			doGet(req, resp);
		}

	}
}
