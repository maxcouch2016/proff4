package service;

import java.util.List;

import dao.ContructorDao;
import domain.Contructor;
 
public class ConstructorServiceImpl implements ConstructorService {
	private ContructorDao constrDao = null;

	public ConstructorServiceImpl(ContructorDao constrDao) {
		this.constrDao = constrDao;
	}

	@Override
	public void addNewConstructor(Contructor constr) {
		constrDao.create(constr);
	}

	@Override
	public List<Contructor> getAllConstructors() {
		return constrDao.findAll();
	}

	@Override
	public void updateConstructor(Contructor constr) {
		constrDao.update(constr);
	}

	@Override
	public void deleteConstructor(Contructor constr) {
		constrDao.delete(constr);		
	}

	@Override
	public void addNewConstructors(Contructor[] constrs) {
		for(Contructor constr:constrs){
			constrDao.create(constr);
		}
		
	}

	@Override
	public List<Contructor> getAllConstructorsByBeginString(String begin) {
		return constrDao.findContructorsByBeginString(begin);
	}


}

