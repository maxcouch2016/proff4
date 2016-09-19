package service;

import java.util.List;

import domain.Worker;


public interface WorkerService {	
	void addNewWorker(Worker worker);
	void updateWorker(Worker worker);
	void deleteWorker(Worker worker);
	List<Worker> getAllWorkers(); 
	Integer getPageCount();
	void updateWorkerById(String id , String firstName , String lastName , String salary , String birtDate , int status , String department);
}

