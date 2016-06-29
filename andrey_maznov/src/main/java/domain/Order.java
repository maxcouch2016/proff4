package domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
 
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="number")
	private String number;

	@Column(name="summa")
	private Integer summa;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="contructor_id")
	private Contructor contructor;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	private Set<OrderPositions> order_positions;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="user_id")
 	private User user;
	
	public Set<OrderPositions> getOrderPositions() {
		return order_positions;
	}
	
	public void setOrderPositions(Set<OrderPositions> order_positions) {
		this.order_positions = order_positions;
	}
	
	public Contructor getContructor() {
		return contructor;
	}
	
	public void setContructor(Contructor contructor) {
		this.contructor = contructor;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getSumma() {
		return summa;
	}

	public void setSumma(Integer summa) {
		this.summa = summa;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Order() {
	}
	
	public Order(String number, Integer summa) {
		this.number = number;
		this.summa = summa;
	}
	
	public Order(String number) {
		this(number, 0);
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", summa=" + summa + ", contructor=" + contructor + ", user=" + user + "]";
	}

}
