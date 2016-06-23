package dao;

import java.util.List;

import domain.Employee;

public interface EmployeeDao {

	Long create(Employee empl);
	Employee read(Long id);
    void update(Employee empl);
    void delete(Employee empl);
    List<Employee> findAll();
    List<Employee> findEmployeesByBeginString(String begin);
	
}
