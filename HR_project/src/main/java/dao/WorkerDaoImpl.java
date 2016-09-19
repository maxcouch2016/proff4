package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import domain.Worker;


@Repository("workerDao")
public class WorkerDaoImpl implements WorkerDao {
	private static Logger log = Logger.getLogger(WorkerDaoImpl.class);
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	
	}


	@Override
	public Long create(Worker worker) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(worker);
		log.error("Worker saved successfully, wokrer= " + worker);
		return id;
	}

	@Override
	public Worker read(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Worker worker = (Worker) session.get(Worker.class, id);
		log.error("Worker read successfully, worker= " + worker);
		return worker;
	}

	@Override
	public void update(Worker worker) {
		Session session = sessionFactory.getCurrentSession();
		session.update(worker);
		log.error("Worker update successfully, worker= " + worker);
	}

	@Override
	public void delete(Worker worker) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(worker);
		log.info("Worker deleted successfully, worker details=" + worker);
	}

	@Override
	public List<Worker> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Worker");
		return query.list();
	}

}

