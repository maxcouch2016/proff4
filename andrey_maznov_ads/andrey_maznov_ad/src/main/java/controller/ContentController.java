package controller;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import dao.CatalogDao;
import dao.ContentDao;
import dao.UserDao;
import domain.Catalog;
import domain.Content;
import domain.User;
import service.CatalogService;
import service.ContentService;
import service.UserService;
import util.HibernateUtil;

@WebServlet("/content")
public class ContentController extends HttpServlet {
	
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		User user = (User) req.getSession().getAttribute("user");
		
		ContentService service = new ContentService(new ContentDao(factory));
		
		String catalogType = req.getParameter("contenttype");
		
		if (user != null) {

			List<Content> contents = service.getAllContentsByUser(user);

			req.setAttribute("contents", contents);
			
			StringBuilder sb = new StringBuilder("<form method=\"post\">");
			sb.append("<select class = \"editAd\" name=\"catalogNewMessage\">");
			sb.append("<option value=\"1\">Авто</option>");
			sb.append("<option value=\"2\">Недвижимость</option>");
			sb.append("<option value=\"3\">Работа</option>");
			sb.append("</select>");
			sb.append("<textarea class = \"editAd\" name=\"textNewMessage\"></textarea>");
			sb.append("<input class = \"addAdButton\" type=\"submit\" value=\"Добавить\">");
			sb.append("</form>");
				
			req.setAttribute("formText", sb.toString());
			
		} else if (catalogType != null) {
			
			String catalog = matchCatalog(catalogType);
			
			CatalogService catalogService = new CatalogService(new CatalogDao(factory));
			
			List<Content> contents = service.getAllContentsByCatalog(catalogService.getCatalogByName(catalog));

			req.setAttribute("contents", contents);

			
		} else {

			List<Content> contents = service.getAllContents();

			req.setAttribute("contents", contents);

		}
		
		req.getRequestDispatcher("jsp/content.jsp").forward(req, resp);
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String catalog = req.getParameter("catalogNewMessage");

		String text = req.getParameter("textNewMessage");
		
		if (text != null && !text.isEmpty()) {

			ContentService contentService = new ContentService(new ContentDao(factory));

			CatalogService catalogService = new CatalogService(new CatalogDao(factory));

			UserService userService = new UserService(new UserDao(factory));

			catalog = matchCatalog(catalog);

			contentService
					.addNewContent(new Content(text, new GregorianCalendar(), catalogService.getCatalogByName(catalog),
							userService.getUserByName(req.getSession().getAttribute("user").toString())));

		}
		
		doGet(req, resp);
		
	}
	
	private String matchCatalog(String index) {
		
		if (index.equals("1")) {
			return "Авто";
		}
		else if (index.equals("2")) {
			return "Недвижимость";
		}
		else if (index.equals("3")) {
			return "Работа";
		}
		
		return null;
		
	}
	
}
