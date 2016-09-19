package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Message;
import service.ServiceMessageImpl;

@WebServlet("/content")
public class ContentController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServiceMessageImpl service = new ServiceMessageImpl();
		List<Message> mess = service.getAllMassage();
		
		req.setAttribute("mess", mess);
		
		req.getRequestDispatcher("jsp/content.jsp").forward(req, resp);
	}
}
