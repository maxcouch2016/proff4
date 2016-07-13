package action09;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Employees;

import util.HibernateUtil;

public class MainEmployes {
	private static Logger log = Logger.getLogger(MainProductExample.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();//слой хибирнейта поставщик ссесии
		Session session = factory.openSession();
		
		Employees employees = new Employees("Maxim", 123,1);
		try{
			session.beginTransaction();//транзакция хибирнейтом
			session.save(employees);
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
