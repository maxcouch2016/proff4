package service;

import java.util.List;
import dao.EmployeeDao;
import domain.Employee;
 
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao emplDao = null;

	public EmployeeServiceImpl(EmployeeDao emplDao) {
		this.emplDao = emplDao;
	}

	@Override
	public void addNewEmployee(Employee empl) {
		emplDao.create(empl);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return emplDao.findAll();
	}

	@Override
	public void updateEmployee(Employee empl) {
		emplDao.update(empl);
		
	}

	@Override
	public void deleteEmployee(Employee empl) {
		emplDao.delete(empl);
		
	}

	@Override
	public void addNewEmployees(Employee[] empls) {
		for(Employee empl:empls){
			emplDao.create(empl);
		}
		
	}

	@Override
	public List<Employee> getAllEmployeesByBeginString(String begin) {
		return emplDao.findEmployeesByBeginString(begin);
	}

}

