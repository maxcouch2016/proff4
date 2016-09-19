package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import domain.User;


@Repository("userDao")
public class UserDaoImpl implements UserDao {
	private static Logger log = Logger.getLogger(UserDaoImpl.class);
	
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	
	}


	@Override
	public Long create(User user) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(user);
		log.error("User saved successfully, user="+user);
		return id;
	}

	@Override
	public User read(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		log.error("User read successfully, user="+user);
		return user;
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		log.error("User update successfully, user="+user);
	}

	@Override
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
		log.info("User deleted successfully, user details="+user);
	}

	@Override
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		return query.list();
	}

}

