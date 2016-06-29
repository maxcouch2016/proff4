package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Order;
 
public class OrderDaoImpl implements OrderDao {
	private static Logger log = Logger.getLogger(OrderDaoImpl.class);
	
	private SessionFactory sessionF;
	public OrderDaoImpl(SessionFactory sessionF){
		this.sessionF = sessionF;
	}
	@Override
	public Long create(Order order) {
		Session session = sessionF.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	@Override
	public Order read(Long id) {
		Session session = sessionF.openSession();
		Order order = null;
		try {
			order = (Order) session.get(Order.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return order;
	}

	@Override
	public void update(Order order) {
		Session session = sessionF.openSession();
		try {
			session.beginTransaction();
			session.update(order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public void delete(Order order) {
		Session session = sessionF.openSession();
		try {
			session.beginTransaction();
			session.delete(order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Order> findAll() {
		Session session = sessionF.openSession();
		try {
			Query query = session.createQuery("from Order");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
		
	}

	@Override
	public List<Order> findOrdersByBeginString(String begin) {
		Session session = sessionF.openSession();
		try {
			Query query = session.createSQLQuery("select * from orders where orders.name like :a").addEntity(Order.class);
			query.setString("a", begin + "%");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
