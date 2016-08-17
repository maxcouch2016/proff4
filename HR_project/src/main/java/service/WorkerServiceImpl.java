package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.WorkerDao;
import domain.Worker;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService {
	private WorkerDao workerDao;
	
	@Autowired(required=true)
	public void setWorkerDao(WorkerDao workerDao) {
		this.workerDao = workerDao;
	}

	@Override
	@Transactional
	public void addNewWorker(Worker worker) {
		workerDao.create(worker);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Worker> getAllWorkers() {
		return workerDao.findAll();
	}

	@Override
	@Transactional
	public void updateWorker(Worker worker) {
		workerDao.update(worker);
		
	}

	@Override
	@Transactional
	public void deleteWorker(Worker worker) {
		workerDao.delete(worker);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Integer getPageCount() {
		List<Worker> workers = workerDao.findAll();
		int countWorkers = workers.size();
		Integer pageCount = (int)Math.round(countWorkers/40 + 0.5);
		return pageCount;
	}

	@Override
	@Transactional
	public void updateWorkerById(String id , String firstName , String lastName , String salary , String birthDate , int status , String department) {
		Long currentId = Long.valueOf(id);
		Worker worker = workerDao.read(currentId);
		worker.setName(firstName);
		worker.setLastname(lastName);
		double currentSalary = Double.parseDouble(salary);
		worker.setSalary(currentSalary);
		worker.setBirthdate(birthDate);
		worker.setStatus(status);
		worker.setDepartment(department);
		workerDao.update(worker);
		System.out.println("Worker updated succesfully");
	}

}
