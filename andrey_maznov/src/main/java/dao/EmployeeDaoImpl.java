package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Employee;
 
public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	
	private SessionFactory sf;
	public EmployeeDaoImpl(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public Long create(Employee empl) {
		Session session = sf.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(empl);
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
	public Employee read(Long id) {
		Session session = sf.openSession();
		Employee empl = null;
		try {
			empl = (Employee) session.get(Employee.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return empl;
	}

	@Override
	public void update(Employee empl) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.update(empl);
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
	public void delete(Employee empl) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.delete(empl);
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
	public List<Employee> findAll() {
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from Employee");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Employee> findEmployeesByBeginString(String begin) {
		Session session = sf.openSession();
		try {
			List<Employee> list = null; 
			Query query = session.createSQLQuery("select * from employees where employees.name like :a").addEntity(Employee.class);
			query.setString("a", begin + "%");
			list = query.list();
			return list;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
