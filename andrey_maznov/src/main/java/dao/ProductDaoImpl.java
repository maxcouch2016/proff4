package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Product;
 
public class ProductDaoImpl implements ProductDao {
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);
	
	private SessionFactory sf;
	public ProductDaoImpl(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public Long create(Product product) {
		Session session = sf.openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(product);
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
	public Product read(Long id) {
		Session session = sf.openSession();
		Product product = null;
		try {
			product = (Product) session.get(Product.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return product;
	}

	@Override
	public void update(Product product) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.update(product);
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
	public void delete(Product product) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.delete(product);
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
	public List<Product> findAll() {
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from Product");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Product> findProductsByBeginString(String begin) {
		Session session = sf.openSession();
		try {
			Query query = session.createSQLQuery("select * from product where product.name like :a").addEntity(Product.class);
			query.setString("a", begin + "%");
			return query.list();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
