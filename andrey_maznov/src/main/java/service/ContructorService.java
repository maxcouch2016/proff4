package service;

import java.util.List;

import domain.Contructor;;

public interface ContructorService {
	void addNewContructor(Contructor constr);
	void addNewContructors(Contructor[] constr);
	void updateContructor(Contructor constr);
	void deleteContructor(Contructor constr);
	List<Contructor> getAllContructors();
	List<Contructor> getAllContructorsByBeginString(String begin); 
}
