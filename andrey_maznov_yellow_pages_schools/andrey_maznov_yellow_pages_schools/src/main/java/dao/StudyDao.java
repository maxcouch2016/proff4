package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Study;

public class StudyDao {

	private static Logger log = Logger.getLogger(StudyDao.class);

	private SessionFactory sessionFactory;

	public StudyDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(Study study) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(study);
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

	public Study read(Long id) {
		Session session = sessionFactory.openSession();
		Study study = null;
		try {
			study = (Study) session.get(Study.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return study;
	}

	public void update(Study study) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(study);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void delete(Study study) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(study);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<Study> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Study");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<String> findAllStudiesNames() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select study.name from study");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
//	public Study findCatalogByName(String name) {
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
