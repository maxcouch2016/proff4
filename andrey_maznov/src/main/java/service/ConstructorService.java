package service;

import java.util.List;

import domain.Contructor;;

public interface ConstructorService {
	void addNewConstructor(Contructor constr);
	void addNewConstructors(Contructor[] constr);
	void updateConstructor(Contructor constr);
	void deleteConstructor(Contructor constr);
	List<Contructor> getAllConstructors();
	List<Contructor> getAllConstructorsByBeginString(String begin); 
}
