package action09;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dao.ContructorDaoImpl;
import dao.OrderDaoImpl;
import dao.OrderPositionsDaoImpl;
import domain.Contructor;
import domain.Employee;
import domain.Order;
import domain.OrderPositions;
import domain.Product;
import domain.User;
import service.ContructorService;
import service.ContructorServiceImpl;
import service.OrderPositionService;
import service.OrderPositionServiceImpl;
import service.OrderService;
import service.OrderServiceImpl;
import util.HibernateUtilTest;

public class DBTests {

	public static void main(String[] args) {
		
//		contructorTest();
//		orderConstructorTest();
//		orderPositionsProductTest();
//		orderPositionsOrderTest();
//		orderUserTest();
		
	}

	public static void orderUserTest() {
		
		Session session = HibernateUtilTest.getSession();

		OrderService service = new OrderServiceImpl(new OrderDaoImpl(session));
		
		List<Order> list = service.getAllOrders();
		
		for (Order order : list) {
			System.out.println(order.getOrderPositions());
		}
		
	}
	
	public static void orderPositionsOrderTest() {
		
		Session session = HibernateUtilTest.getSession();
		
		OrderService service = new OrderServiceImpl(new OrderDaoImpl(session));
		
		Order newOrder = new Order("ZAK011", 1000);
		
		User user = new User("Test", "login", "password");
		user.setEmployee(new Employee("Test", 123));
		
		newOrder.setUser(user);
		
		Set<OrderPositions> order_positions = new HashSet<>();
		
		Product product = new Product("Молоко", 7848);
		
		for (int i = 0; i < 1; i++) {
			OrderPositions orderPosition = new OrderPositions(12 + i);
			orderPosition.setProduct(product);
			orderPosition.setOrder(newOrder);
			order_positions.add(orderPosition);
		}
		
		newOrder.setOrderPositions(order_positions);
		
		service.addNewOrder(newOrder);
		
//		List<Order> list = service.getAllOrders();
//		try {
//			session.close();
//			for (Order order : list) {
//				System.out.println(order.getOrderPositions());
//			}
//		}
//		catch (Exception e) {
//			System.out.println("Can't get positions with lazy fetch after session close!");
//		}
//		
//		session = HibernateUtilTest.getSession();
//		
//		OrderPositionService positionsService = new OrderPositionServiceImpl(new OrderPositionsDaoImpl(session));
//		
//		List<OrderPositions> positionsList = positionsService.getAllOrderPositions();
//		
//		for (OrderPositions orderPositions : positionsList) {
//			System.out.println(orderPositions);
//		}
		
		try {
			session.close();
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
	public static void orderPositionsProductTest() {
		
		Session session = HibernateUtilTest.getSession();
		
		OrderPositionService service = new OrderPositionServiceImpl(new OrderPositionsDaoImpl(session));
		
		List<OrderPositions> list = service.getAllOrderPositions();
		
		System.out.println(list);
		
		OrderPositions position = new OrderPositions(100);
		position.setProduct(new Product("Тестовый продукт", 999));
		service.addNewOrderPosition(position);
		
		try {
			session.close();
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
	public static void orderConstructorTest() {
		
		Session session = HibernateUtilTest.getSession();
		
		OrderService orderService = new OrderServiceImpl(new OrderDaoImpl(session));
		
		List<Order> list = orderService.getAllOrders();
		
		System.out.println(list);
		
		Order newOrder = new Order("ZAK009", 999);
		
		User user = new User("Test1", "login1", "password1");
		user.setEmployee(new Employee("Test1", 555));
		
		newOrder.setUser(user);
		
		newOrder.setContructor(new Contructor("ОАО Новый для теста заказа"));
		orderService.addNewOrder(newOrder);
		
		try {
			session.close();
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
	public static void contructorTest() {
	
		Session session = HibernateUtilTest.getSession();
		
		ContructorService contrService = new ContructorServiceImpl(new ContructorDaoImpl(session));
		
		List<Contructor> list = contrService.getAllContructors();
		
		System.out.println(list);
		
		int i = 1; 
		
		for (Contructor contructor : list) {
			contructor.setName("OOO Аметист" + i);
			contrService.updateContructor(contructor);
			i++;
		}
		
		Contructor newContructor = new Contructor("ООО Добавленное");
		
		contrService.addNewContructor(newContructor);
		
		Contructor deleteContructor = new Contructor("ООО Добавленное для удаления");
		
		contrService.deleteContructor(deleteContructor);
		
		try {
			session.close();
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
}
