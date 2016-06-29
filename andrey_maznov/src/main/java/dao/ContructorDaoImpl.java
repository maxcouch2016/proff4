package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Contructor;;
 
public class ContructorDaoImpl implements ContructorDao {
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);
	private SessionFactory sessionFactory;
	
	public ContructorDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Long create(Contructor contr) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(contr);
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
	public Contructor read(Long id) {
		Session session = sessionFactory.openSession();
		Contructor contr = null;
		try {
			contr = (Contructor) session.get(Contructor.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return contr;
	}

	@Override
	public void update(Contructor contr) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(contr);
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
	public void delete(Contructor contr) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(contr);
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
	public List<Contructor> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Contructor");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Contructor> findContructorsByBeginString(String begin) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from contructors where contructors.name like :a").addEntity(Contructor.class);
			query.setString("a", begin + "%");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
