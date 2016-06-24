package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
 
@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="salary")
	private int salary;

	@Column(name="user_id")
	private int user_id = 0;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", user_id=" + user_id + "]";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Employee() {
	}

	public Employee(String name, int salary) {
		this(name, salary, 0);
	}

	public Employee(String name) {
		this(name, 0, 0);
	}
	
	public Employee(String name, int salary, int user_id) {
		this.name = name;
		this.salary = salary;
		this.user_id = user_id;
	}
	
}