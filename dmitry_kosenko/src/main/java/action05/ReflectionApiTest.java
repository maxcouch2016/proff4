package Action05;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

/*
Задача1: Вывести все методы класса String

Задача2(ReflectionTask1Example) Написать метод принимающий любой объект.
Метод возвращает все классы в иерархию которых входит данный объект. 

Задача3:(ReflectionTask2Example) Написать метод, принимающий любой объект, выводящий список 
всех интерфейсов по иерархии наследования классов.
*/

public class ReflectionApiTest {

	public static void main(String[] args) {
		System.out.println(getAllObjectMethods(new String()));
		System.out.println(getParents(new ArrayList<>()));
		System.out.println(getInterfaces(new ArrayList<>()));
	}
	
	
	// Task 1
	public static ArrayList<Method> getAllObjectMethods(Object o) {
		
		ArrayList<Method> list = new ArrayList<>(); 
		
		Method[] methods = o.getClass().getDeclaredMethods();
		
		for (int i = 0; i < methods.length; i++) {
			list.add(methods[i]);
		}
		
		return list;
		
	}
	
	//Task 2
	public static ArrayList<Class<?>> getParents(Object obj) {
		
		ArrayList<Class<?>> list = new ArrayList<>(); 
		
		list.add(obj.getClass());
		
		Class<?> cls = obj.getClass().getSuperclass();
		
		while (cls != null) {
			list.add(cls);
			cls = cls.getSuperclass();
		}
		
		return list;
		
	}
	
	// Task 3
	public static HashSet<Class<?>> getInterfaces(Object obj) {

		HashSet<Class<?>> resultSet = new HashSet<>(); 
		
		ArrayList<Class<?>> classes = getParents(obj);
		
		for (Class<?> cl : classes) {
			Class<?> inf[] = cl.getInterfaces();
			for (int i = 0; i < inf.length; i++) {
				resultSet.add(inf[i]);
			}
		}
		
		return resultSet;

	}
	
}
