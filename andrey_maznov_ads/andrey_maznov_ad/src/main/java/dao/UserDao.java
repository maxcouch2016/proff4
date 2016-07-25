package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Catalog;
import domain.User;

public class UserDao {

	private static Logger log = Logger.getLogger(UserDao.class);

	private SessionFactory sessionFactory;

	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(User user) {
		Session session = sessionFactory.openSession();
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

	public User read(Long id) {
		Session session = sessionFactory.openSession();
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

	public void update(User user) {
		Session session = sessionFactory.openSession();
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

	public void delete(User user) {
		Session session = sessionFactory.openSession();
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

	public List<User> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from User");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public User findUserByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from user where user.name = :a limit 1").addEntity(User.class);
			query.setString("a", name);
			return query.list().size() > 0 ? (User) query.list().get(0) : null;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public User findUserByLoginPassword(String login, String pass) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from user where user.login = :a && user.pass = :b limit 1").addEntity(User.class);
			query.setString("a", login);
			query.setString("b", pass);
			return query.list().size() > 0 ? (User) query.list().get(0) : null;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
}
