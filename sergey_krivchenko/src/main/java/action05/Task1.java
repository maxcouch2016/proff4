package action05;

import java.lang.reflect.Method;

public class Task1 {

	public static void main(String[] args){
		
		String str = new String();
		 
		 Class<?> clazz = str.getClass();
		 
		 Method[] methods = clazz.getMethods();
		 
		 for (int i = 0; i < methods.length; i++) {
			System.out.print(methods[i].getName() + " / ");
		}
		 
		 
		
		
		
	}
	
}
