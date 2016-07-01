package service;

import java.util.List;

import dao.ContructorDao;
import domain.Contructor;
 
public class ContructorServiceImpl implements ContructorService {
	private ContructorDao constrDao = null;

	public ContructorServiceImpl(ContructorDao constrDao) {
		this.constrDao = constrDao;
	}

	@Override
	public void addNewContructor(Contructor constr) {
		constrDao.create(constr);
	}

	@Override
	public List<Contructor> getAllContructors() {
		return constrDao.findAll();
	}

	@Override
	public void updateContructor(Contructor constr) {
		constrDao.update(constr);
	}

	@Override
	public void deleteContructor(Contructor constr) {
		constrDao.delete(constr);		
	}

	@Override
	public void addNewContructors(Contructor[] constrs) {
		for(Contructor constr:constrs){
			constrDao.create(constr);
		}
		
	}

	@Override
	public List<Contructor> getAllContructorsByBeginString(String begin) {
		return constrDao.findContructorsByBeginString(begin);
	}


}

