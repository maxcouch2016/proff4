package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Role;
 
public class RoleDaoImpl implements RoleDao {
	private static Logger log = Logger.getLogger(RoleDaoImpl.class);
	
	private SessionFactory sf;
	public RoleDaoImpl(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public Long create(Role role) {
		Session session = sf.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(role);
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
	public Role read(Long id) {
		Session session = sf.openSession();
		Role role = null;
		try {
			role = (Role) session.get(Role.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return role;
	}

	@Override
	public void update(Role role) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.update(role);
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
	public void delete(Role role) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.delete(role);
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
	public List<Role> findAll() {
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from Role");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Role> findRolesByBeginString(String begin) {
		Session session = sf.openSession();
		try {
			List<Role> list = null; 
			Query query = session.createSQLQuery("select * from roles where roles.name like :a").addEntity(Role.class);;
			query.setString("a", begin + "%");
			list = query.list();
			return list;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
