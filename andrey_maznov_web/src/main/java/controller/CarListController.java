package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceCar;
import service.ServiceCarImpl;

public class CarListController extends HttpServlet{

	private ServiceCar service = new ServiceCarImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("cars", service.getAllCars());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/car_list.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String number = req.getParameter("number");
		
		String model = req.getParameter("model");
		
		if (!model.isEmpty() && !number.isEmpty()) {
			service.addCarToList(number, model);
		}
		
		doGet(req, resp);
		
	}
	
}
