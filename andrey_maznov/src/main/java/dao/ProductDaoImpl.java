package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Product;
 
public class ProductDaoImpl implements ProductDao {
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);
	
	private Session session;
	public ProductDaoImpl(Session session){
		this.session = session;
	}
	@Override
	public Long create(Product product) {
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
		return id;
	}

	@Override
	public Product read(Long id) {
		Product product = null;
		try {
			product = (Product) session.get(Product.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		}
		return product;
	}

	@Override
	public void update(Product product) {
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Product product) {
		try {
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<Product> findAll() {
		try {
			Query query = session.createQuery("from Product");
			return query.list();
		}
		catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

	@Override
	public List<Product> findProductsByBeginString(String begin) {
		try {
			Query query = session.createSQLQuery("select * from product where product.name like :a").addEntity(Product.class);
			query.setString("a", begin + "%");
			return query.list();
		}catch (HibernateException e) {
			log.error("Transaction failed");
			return null;
		}
	}

}
