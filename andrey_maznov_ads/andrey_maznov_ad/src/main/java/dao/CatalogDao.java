package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Catalog;

public class CatalogDao {

	private static Logger log = Logger.getLogger(CatalogDao.class);

	private SessionFactory sessionFactory;

	public CatalogDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(Catalog catalog) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(catalog);
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

	public Catalog read(Long id) {
		Session session = sessionFactory.openSession();
		Catalog catalog = null;
		try {
			catalog = (Catalog) session.get(Catalog.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return catalog;
	}

	public void update(Catalog catalog) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(catalog);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void delete(Catalog catalog) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(catalog);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<Catalog> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Catalog");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public Catalog findCatalogByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from catalog where catalog.name = :a limit 1").addEntity(Catalog.class);
			query.setString("a", name);
			return query.list().size() > 0 ? (Catalog) query.list().get(0) : null;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
