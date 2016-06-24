package action09;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Employee;
import util.HibernateUtil;

 
public class MainEmployeeExample {
	private static Logger log = Logger.getLogger(MainEmployeeExample.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Employee emp = new Employee("Vasya Pupkin", 1500);
		try{
			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
			
		}
		try{
			factory.close();
		}catch(Exception e){
			
		}
	}
}
