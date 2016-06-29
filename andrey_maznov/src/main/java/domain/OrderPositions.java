package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
 
@Entity
@Table(name="order_positions")
public class OrderPositions {

	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	private Long id;
	
	@Column(name="count")
	private Integer count;
	
	@Override
	public String toString() {
		return "Order position [id=" + id + ", order=" + order + ", product=" + product + ", count=" + count + "]";
	}
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="order_id")
 	private Order order;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="product_id")
 	private Product product;	
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public OrderPositions() {
	}
	
	public OrderPositions(Integer count) {
		this.count = count;
	}
	
}