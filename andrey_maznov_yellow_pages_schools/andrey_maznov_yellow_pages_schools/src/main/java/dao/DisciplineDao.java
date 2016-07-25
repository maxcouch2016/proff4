package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Discipline;

public class DisciplineDao {

	private static Logger log = Logger.getLogger(DisciplineDao.class);

	private SessionFactory sessionFactory;

	public DisciplineDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(Discipline discipline) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(discipline);
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

	public Discipline read(Long id) {
		Session session = sessionFactory.openSession();
		Discipline discipline = null;
		try {
			discipline = (Discipline) session.get(Discipline.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return discipline;
	}

	public void update(Discipline discipline) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(discipline);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void delete(Discipline discipline) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(discipline);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<Discipline> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Discipline");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<String> findAllDisciplinesNames() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select discipline.name from discipline");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
//	public Discipline findCatalogByName(String name) {
//		Session session = sessionFactory.openSession();
//		try {
//			Query query = session.createSQLQuery("select * from catalog where catalog.name = :a limit 1").addEntity(Catalog.class);
//			query.setString("a", name);
//			return query.list().size() > 0 ? (Catalog) query.list().get(0) : null;
//		} finally {
//			if (session != null)
//				session.close();
//		}
//	}

}
