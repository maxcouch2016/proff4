package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.User;
 
public class UserDaoImpl implements UserDao {
	private static Logger log = Logger.getLogger(UserDaoImpl.class);
	
	private Session session;
	public UserDaoImpl(Session session){
		this.session = session;
	}
	@Override
	public Long create(User user) {
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
		return id;
	}

	@Override
	public User read(Long id) {
		User user = null;
		try {
			user = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		}
		return user;
	}

	@Override
	public void update(User user) {
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public void delete(User user) {
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<User> findAll() {
		try {
			Query query = session.createQuery("from User");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

	@Override
	public List<User> findUsersByBeginString(String begin) {
		try {
			List<User> list = null; 
			Query query = session.createSQLQuery("select * from users where users.name like :a").addEntity(User.class);;
			query.setString("a", begin + "%");
			list = query.list();
			return list;
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

}
