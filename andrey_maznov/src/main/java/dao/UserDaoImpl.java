package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.User;
 
public class UserDaoImpl implements UserDao {
	private static Logger log = Logger.getLogger(UserDaoImpl.class);
	
	private SessionFactory sf;
	public UserDaoImpl(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public Long create(User user) {
		Session session = sf.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(user);
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
	public User read(Long id) {
		Session session = sf.openSession();
		User user = null;
		try {
			user = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return user;
	}

	@Override
	public void update(User user) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.update(user);
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
	public void delete(User user) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.delete(user);
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
	public List<User> findAll() {
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from User");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<User> findUsersByBeginString(String begin) {
		Session session = sf.openSession();
		try {
			List<User> list = null; 
			Query query = session.createSQLQuery("select * from users where users.name like :a").addEntity(User.class);;
			query.setString("a", begin + "%");
			list = query.list();
			return list;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
