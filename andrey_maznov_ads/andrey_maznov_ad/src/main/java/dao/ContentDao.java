package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Content;
import domain.User;

public class ContentDao {

	private static Logger log = Logger.getLogger(ContentDao.class);

	private SessionFactory sessionFactory;

	public ContentDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(Content content) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(content);
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

	public Content read(Long id) {
		Session session = sessionFactory.openSession();
		Content content = null;
		try {
			content = (Content) session.get(Content.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return content;
	}

	public void update(Content content) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(content);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void delete(Content content) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(content);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<Content> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Content");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<Content> findAllByUser(Long user_id) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from content where content.user_id = :a").addEntity(Content.class);
			query.setLong("a", user_id);
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<Content> findAllByCatalog(Long catalog_id) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from content where content.catalog_id = :a").addEntity(Content.class);
			query.setLong("a", catalog_id);
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
