package service;

import java.util.List;

import domain.Employee;

public interface EmployeeService {
	void addNewEmployee(Employee empl);
	void addNewEmployees(Employee[] empl);
	void updateEmployee(Employee empl);
	void deleteEmployee(Employee empl);
	List<Employee> getAllEmployees();
	List<Employee> getAllEmployeesByBeginString(String begin);
}
