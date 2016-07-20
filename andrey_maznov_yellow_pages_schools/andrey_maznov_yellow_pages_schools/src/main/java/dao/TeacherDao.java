package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.City;
import domain.School;
import domain.Teacher;

public class TeacherDao {

	private static Logger log = Logger.getLogger(TeacherDao.class);

	private SessionFactory sessionFactory;

	public TeacherDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long create(Teacher teacher) {
		Session session = sessionFactory.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(teacher);
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

	public Teacher read(Long id) {
		Session session = sessionFactory.openSession();
		Teacher teacher = null;
		try {
			teacher = (Teacher) session.get(Teacher.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return teacher;
	}

	public void update(Teacher teacher) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(teacher);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void delete(Teacher teacher) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(teacher);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<Teacher> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Teacher");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<String> findAllTeachersNames() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select teacher.name from teacher");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public List<String> findTeacherBySchool(School school) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select teacher.name from teacher where teacher.school_id = :a");
			query.setLong("a", school.getId());
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public Teacher findTeacherByNameInSchool(String teacher, School school) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery("select * from teacher where teacher.name = :a and teacher.school_id = :b limit 1").addEntity(Teacher.class);
			query.setString("a", teacher);
			query.setLong("b", school.getId());
			return query.list().size() > 0 ? (Teacher) query.list().get(0) : null;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
