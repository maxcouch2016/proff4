package action09;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dao.ContructorDaoImpl;
import dao.OrderDaoImpl;
import dao.OrderPositionsDaoImpl;
import dao.UserDaoImpl;
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
import service.UserService;
import service.UserServiceImpl;
import util.HibernateUtilTest;

public class DBTests {

	public static void main(String[] args) {
		
//		contructorTest();
//		orderConstructorTest();
//		orderPositionsProductTest();
		orderPositionsOrderTest();
//		orderUserTest();
		
	}
	
	public static void orderUserTest() {
		
		OrderService service = new OrderServiceImpl(new OrderDaoImpl(HibernateUtilTest.getSessionFactory()));
		
		List<Order> list = service.getAllOrders();
		
		for (Order order : list) {
			System.out.println(order.getOrderPositions());
		}
		
		try {
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
	public static void orderPositionsOrderTest() {
		
		OrderService service = new OrderServiceImpl(new OrderDaoImpl(HibernateUtilTest.getSessionFactory()));
		
		Order newOrder = new Order("ZAK012", 1111);
		
		newOrder.setContructor(new Contructor("My final contructor"));
		
		User user = new User("TestFinal", "login132", "pass555word");
		user.setEmployee(new Employee("Test", 888));
		
		newOrder.setUser(user);
		
		Set<OrderPositions> order_positions = new HashSet<>();
		
		Product product = new Product("Floppy disk", 1545);
		
		for (int i = 0; i < 1; i++) {
			OrderPositions orderPosition = new OrderPositions(89 + i);
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
//		OrderPositionService positionsService = new OrderPositionServiceImpl(new OrderPositionsDaoImpl(HibernateUtilTest.getSessionFactory()));
//		
//		List<OrderPositions> positionsList = positionsService.getAllOrderPositions();
//		
//		for (OrderPositions orderPositions : positionsList) {
//			System.out.println(orderPositions);
//		}
		
		try {
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
	public static void orderPositionsProductTest() {
		
		OrderPositionService service = new OrderPositionServiceImpl(new OrderPositionsDaoImpl(HibernateUtilTest.getSessionFactory()));
		
		List<OrderPositions> list = service.getAllOrderPositions();
		
		System.out.println(list);
		
		OrderPositions position = new OrderPositions(100);
		position.setProduct(new Product("Тестовый продукт", 999));
		service.addNewOrderPosition(position);
		
		try {
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
	public static void orderConstructorTest() {
		
		OrderService orderService = new OrderServiceImpl(new OrderDaoImpl(HibernateUtilTest.getSessionFactory()));
		
		List<Order> list = orderService.getAllOrders();
		
		System.out.println(list);
		
		Order newOrder = new Order("ZAK009", 999);
		
		User user = new User("Test1", "login1", "password1");
		user.setEmployee(new Employee("Test1", 555));
		
		newOrder.setUser(user);
		
		newOrder.setContructor(new Contructor("ОАО Новый для теста заказа"));
		orderService.addNewOrder(newOrder);
		
		try {
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
	public static void contructorTest() {
	
		ContructorService contrService = new ContructorServiceImpl(new ContructorDaoImpl(HibernateUtilTest.getSessionFactory()));
		
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
			HibernateUtilTest.getSessionFactory().close();
		} catch(Exception e){
			
		}
		
	}
	
}
