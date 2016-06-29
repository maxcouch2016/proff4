package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.OrderPositions;;
 
public class OrderPositionsDaoImpl implements OrderPositionsDao {
	private static Logger log = Logger.getLogger(OrderPositionsDaoImpl.class);
	
	private Session session;
	public OrderPositionsDaoImpl(Session session){
		this.session = session;
	}
	@Override
	public Long create(OrderPositions orderPosition) {
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(orderPosition);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
		return id;
	}

	@Override
	public OrderPositions read(Long id) {
		OrderPositions orderPosition = null;
		try {
			orderPosition = (OrderPositions) session.get(OrderPositions.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		}
		return orderPosition;
	}

	@Override
	public void update(OrderPositions orderPosition) {
		try {
			session.beginTransaction();
			session.update(orderPosition);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}

	}

	@Override
	public void delete(OrderPositions orderPosition) {
		try {
			session.beginTransaction();
			session.delete(orderPosition);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<OrderPositions> findAll() {
		try {
			Query query = session.createQuery("from OrderPositions");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
		
	}

	@Override
	public List<OrderPositions> findOrderPositionssByBeginString(String begin) {
		try {
			Query query = session.createSQLQuery("select * from order_positions where order_positions.name like :a").addEntity(OrderPositions.class);
			query.setString("a", begin + "%");
			return query.list();
		}catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

}
