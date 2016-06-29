package dbTests;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import dao.ContructorDaoImpl;
import domain.Contructor;
import service.ContructorService;
import service.ContructorServiceImpl;
import util.HibernateUtilTest;

public class ContructorsTest {

	private static int countOfComleteTests;
	
	private ContructorService service = new ContructorServiceImpl(new ContructorDaoImpl(HibernateUtilTest.getSessionFactory()));
		
	@Test
	public void addTest() {
				
		Contructor contructor = new Contructor("Test name " + (int) (Math.random() * 10));
		
		service.addNewContructor(contructor);
		
		List<Contructor> list = service.getAllContructors();
		
		boolean isEqual = false;
		
		for (Contructor contr : list) {
			isEqual = contr.equals(contructor);
			if (isEqual) break;
		}
		
		service.deleteContructor(contructor);
		
		countOfComleteTests++;
		
		if (!isEqual) fail("Not added " + contructor);
		
	}
	
//	@Ignore
	@Test
	public void updateTest() {
				
		Contructor contructor = new Contructor("Test name " + (int) (Math.random() * 10));
		
		service.addNewContructor(contructor);
		
		String newName = "UUUUUUU";
		
		contructor.setName(newName);
		
		service.updateContructor(contructor);
		
		List<Contructor> list = service.getAllContructors();
		
		boolean isEqual = false;
		Contructor fromDB = null;
		
		for (Contructor contr : list) {
			isEqual = contr.equals(contructor);
			if (isEqual) {
				fromDB = contr;
				break;
			}
		}
		
		service.deleteContructor(contructor);
		
		countOfComleteTests++;
		
		if (fromDB == null || !fromDB.getName().equals(newName)) fail("Name not changed " + contructor);
		
	}
	
//	@Ignore
	@Test
	public void deleteTest() {
		
		Contructor contructor = new Contructor("Test name " + (int) (Math.random() * 10));
		
		service.addNewContructor(contructor);
		
		service.deleteContructor(contructor);
		
		List<Contructor> list = service.getAllContructors();
		
		boolean isEqual = false;
		
		for (Contructor contr : list) {
			isEqual = contr.equals(contructor);
			if (isEqual) break;
		}
		
		countOfComleteTests++;
		
		if (isEqual) fail("Not deleted " + contructor);
		
	}

//	@Ignore
	@Test
	public void addSeveralTest() {
				
		Contructor constrs[] = new Contructor[5];
		
		for (int i = 0; i < 5; i++) {
			constrs[i] = new Contructor("Test name " + (int) (Math.random() * 10));
		}
		
		service.addNewContructors(constrs);
		
		List<Contructor> list = service.getAllContructorsByBeginString("Test name");
		
		boolean isInList = false;
		
		for (Contructor contructor : constrs) {
			isInList = list.contains(contructor);
			if (!isInList) break;
		}
		
		for (Contructor contr : constrs) {
			service.deleteContructor(contr);
		}
		
		countOfComleteTests++;
		
		if (list.size() != 5 || !isInList) fail("Test failed");
		
	}
	
	@After
	public void clear() {
		
		if (countOfComleteTests == 4) {
			
			try {
				HibernateUtilTest.getSessionFactory().close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
