package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.OrderPositions;;
 
public class OrderPositionsDaoImpl implements OrderPositionsDao {
	private static Logger log = Logger.getLogger(OrderPositionsDaoImpl.class);
	
	private SessionFactory sf;
	public OrderPositionsDaoImpl(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public Long create(OrderPositions orderPosition) {
		Session session = sf.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(orderPosition);
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
	public OrderPositions read(Long id) {
		Session session = sf.openSession();
		OrderPositions orderPosition = null;
		try {
			orderPosition = (OrderPositions) session.get(OrderPositions.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return orderPosition;
	}

	@Override
	public void update(OrderPositions orderPosition) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.update(orderPosition);
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
	public void delete(OrderPositions orderPosition) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.delete(orderPosition);
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
	public List<OrderPositions> findAll() {
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from OrderPositions");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
		
	}

	@Override
	public List<OrderPositions> findOrderPositionssByBeginString(String begin) {
		Session session = sf.openSession();
		try {
			Query query = session.createSQLQuery("select * from order_positions where order_positions.name like :a").addEntity(OrderPositions.class);
			query.setString("a", begin + "%");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
