package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.User;

@Repository
//@Transactional
public class UserDaoImpl implements UserDao {

	private static Logger log = Logger.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Long create(User user) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(user);
		return id;
	}

	@Override
	public User read(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	@Override
//	@Transactional(readOnly = true)
	public List<User> findAll() {
//		Session session = sessionFactory.getCurrentSession();
		
		Session session = this.sessionFactory.getCurrentSession();
		
		List<User> list = session.createQuery("from User").list();
		
		return list;
		
//		Session session = sessionFactory.openSession();
//		try {
//			Query query = session.createQuery("from User");
//			return query.list();
//		}
//		finally {
//			session.close();
//		}
	}
}
