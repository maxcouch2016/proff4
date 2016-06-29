package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Order;
 
public class OrderDaoImpl implements OrderDao {
	private static Logger log = Logger.getLogger(OrderDaoImpl.class);
	
	private Session session;
	public OrderDaoImpl(Session session){
		this.session = session;
	}
	@Override
	public Long create(Order order) {
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
		return id;
	}

	@Override
	public Order read(Long id) {
		Order order = null;
		try {
			order = (Order) session.get(Order.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		}
		return order;
	}

	@Override
	public void update(Order order) {
		try {
			session.beginTransaction();
			session.update(order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}

	}

	@Override
	public void delete(Order order) {
		try {
			session.beginTransaction();
			session.delete(order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<Order> findAll() {
		try {
			Query query = session.createQuery("from Order");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
		
	}

	@Override
	public List<Order> findOrdersByBeginString(String begin) {
		try {
			Query query = session.createSQLQuery("select * from orders where orders.name like :a").addEntity(Order.class);
			query.setString("a", begin + "%");
			return query.list();
		}catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

}
