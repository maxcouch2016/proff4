/*Задача2(ReflectionTask1Example) Написать метод принимающий любой объект.
 Метод возвращает все классы в иерархию которых входит данный объект. */
package action05;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflect_2 {
	public static <T> void main(String[] args) {
//		ArrayList<T> list = new ArrayList<T>();
//		for (Method csd : list.getClass().getMethods()) {
//			System.out.println(csd);
//		}

		interf(String.class);
	}

	public static void interf(Object o) {
		Class cl = o.getClass();
		Method[] meth = cl.getDeclaredMethods();
		for(Method meth1:meth){
			System.out.println(meth1);
		}
	}
}
