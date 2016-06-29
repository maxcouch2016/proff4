package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Employee;
 
public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	
	private Session session;
	public EmployeeDaoImpl(Session session){
		this.session = session;
	}
	@Override
	public Long create(Employee empl) {
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(empl);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
		return id;
	}

	@Override
	public Employee read(Long id) {
		Employee empl = null;
		try {
			empl = (Employee) session.get(Employee.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		}
		return empl;
	}

	@Override
	public void update(Employee empl) {
		try {
			session.beginTransaction();
			session.update(empl);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Employee empl) {
		try {
			session.beginTransaction();
			session.delete(empl);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<Employee> findAll() {
		try {
			Query query = session.createQuery("from Employee");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

	@Override
	public List<Employee> findEmployeesByBeginString(String begin) {
		try {
			List<Employee> list = null; 
			Query query = session.createSQLQuery("select * from employees where employees.name like :a").addEntity(Employee.class);
			query.setString("a", begin + "%");
			list = query.list();
			return list;
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

}
