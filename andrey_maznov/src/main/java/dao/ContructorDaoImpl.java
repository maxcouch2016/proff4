package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Contructor;;
 
public class ContructorDaoImpl implements ContructorDao {
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);
	private Session session;
	
	public ContructorDaoImpl(Session session){
		this.session = session;
	}
	@Override
	public Long create(Contructor contr) {
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(contr);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
		return id;
	}

	@Override
	public Contructor read(Long id) {
		Contructor contr = null;
		try {
			contr = (Contructor) session.get(Contructor.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		}
		return contr;
	}

	@Override
	public void update(Contructor contr) {
		try {
			session.beginTransaction();
			session.update(contr);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Contructor contr) {
		try {
			session.beginTransaction();
			session.delete(contr);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<Contructor> findAll() {
		try {
			Query query = session.createQuery("from Contructor");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

	@Override
	public List<Contructor> findContructorsByBeginString(String begin) {
		try {
			Query query = session.createSQLQuery("select * from contructors where contructors.name like :a").addEntity(Contructor.class);
			query.setString("a", begin + "%");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

}
