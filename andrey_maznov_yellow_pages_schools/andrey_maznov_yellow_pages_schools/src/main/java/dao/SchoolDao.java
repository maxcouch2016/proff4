package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.City;
import domain.School;

public class SchoolDao {

	private static Logger log = Logger.getLogger(SchoolDao.class);

	private SessionFactory sessionFactory;

	public SchoolDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(School school) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(school);
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

	public School read(Long id) {
		Session session = sessionFactory.openSession();
		School school = null;
		try {
			school = (School) session.get(School.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return school;
	}

	public void update(School school) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(school);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void delete(School school) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(school);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<School> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from School");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<String> findAllSchoolsNames() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select school.name from school");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public School findSchoolByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from school where school.name = :a limit 1").addEntity(School.class);
			query.setString("a", name);
			return query.list().size() > 0 ? (School) query.list().get(0) : null;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<School> findSchoolsByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from school where school.name = :a").addEntity(School.class);
			query.setString("a", name);
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public School findSchoolByNameInCity(String school, City city) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from school where school.name = :a and school.city_id = :b limit 1").addEntity(School.class);
			query.setString("a", school);
			query.setLong("b", city.getId());
			return query.list().size() > 0 ? (School) query.list().get(0) : null;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<String> findSchoolByCity(City city) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select school.name from school where school.city_id = :a");
			query.setLong("a", city.getId());
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
