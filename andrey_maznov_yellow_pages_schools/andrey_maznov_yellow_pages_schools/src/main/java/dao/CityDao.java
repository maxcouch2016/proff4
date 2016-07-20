package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.City;

public class CityDao {

	private static Logger log = Logger.getLogger(CityDao.class);

	private SessionFactory sessionFactory;

	public CityDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(City city) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(city);
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

	public City read(Long id) {
		Session session = sessionFactory.openSession();
		City city = null;
		try {
			city = (City) session.get(City.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return city;
	}

	public void update(City city) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(city);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void delete(City city) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(city);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<City> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from City");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public City findCityByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from city where city.name = :a limit 1").addEntity(City.class);
			query.setString("a", name);
			return query.list().size() > 0 ? (City) query.list().get(0) : null;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<String> findAllCityNames() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select city.name from city");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
}
