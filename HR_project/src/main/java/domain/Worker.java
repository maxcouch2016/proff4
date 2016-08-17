package domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="worker")
public class Worker {

	
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	@Column(name="worker_id")
	private Long worker_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastname;

	@Column(name="salary")
	private double salary;
	
	@Column(name="birthdate")
	private String birthdate;

	@Column(name="status")
	private int status;
	
	@Column(name="department")
	private String department;

	public Long getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(Long worker_id) {
		this.worker_id = worker_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Worker(String name, String lastname, double salary, String birthdate, int status, String department) {
		this.name = name;
		this.lastname = lastname;
		this.salary = salary;
		this.birthdate = birthdate;
		this.status = status;
		this.department = department;
	}
	
	public Worker(){
	}
	
	public String toTableString(){
		String statusToString = "Active";
		if (status == 0){
			statusToString = "Inactive";
		}
		return "<tr><td>" + worker_id + "</td><td>" + name + "</td><td>" + lastname + "</td><td>" + salary +
				"</td><td>" + birthdate + "</td><td>" + statusToString + "</td><td>" + department + "</td></tr>";
	}
	
}
