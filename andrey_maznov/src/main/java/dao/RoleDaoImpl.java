package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Role;
 
public class RoleDaoImpl implements RoleDao {
	private static Logger log = Logger.getLogger(RoleDaoImpl.class);
	
	private Session session;
	public RoleDaoImpl(Session session){
		this.session = session;
	}
	@Override
	public Long create(Role role) {
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(role);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
		return id;
	}

	@Override
	public Role read(Long id) {
		Role role = null;
		try {
			role = (Role) session.get(Role.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		}
		return role;
	}

	@Override
	public void update(Role role) {
		try {
			session.beginTransaction();
			session.update(role);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Role role) {
		try {
			session.beginTransaction();
			session.delete(role);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<Role> findAll() {
		try {
			Query query = session.createQuery("from Role");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

	@Override
	public List<Role> findRolesByBeginString(String begin) {
		try {
			List<Role> list = null; 
			Query query = session.createSQLQuery("select * from roles where roles.name like :a").addEntity(Role.class);;
			query.setString("a", begin + "%");
			list = query.list();
			return list;
		}catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

}
