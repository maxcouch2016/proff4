package action05;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyReflection {

	public static void main(String[] args) {
		// получаем все методы класса

		
		// Задача1: Вывести все методы класса String

		
		
		String a = new String();
		Class aClass = a.getClass();
		Method[] methods = aClass.getMethods();
		for (Method met : methods) {
			System.out.print(met.getName() + " | ");
			
			
			 /*Задача2(ReflectionTask1Example) Написать метод принимающий любой объект.
			  Метод возвращает все классы в иерархию которых входит данный объект. */
		
			
			/* Задача3:(ReflectionTask2Example) Написать метод, принимающий любой объект, 
			 выводящий список всех интерфейсов по иерархии наследования классов.*/

		}
		System.out.println();
		
		
		//reflectionTask1Example(ArrayList<E>);
	}
	public static void reflectionTask1Example(Object a){
//		Class<?> aClass = a.getClass();
//		Class bclass = aClass.getSuperclass();
//		while (bclass.get) {
//			type type = (type) bclass.nextElement();
//			
	//	} 
		

}
	
		
		
	}
	
}
