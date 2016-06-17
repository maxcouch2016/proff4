package action05;

import java.util.ArrayList;

public class ReflectionTask1Example {

	public static void reflectionExample(Object obj) {
		Class<?> clazz = obj.getClass();
		System.out.println(clazz);

		clazz = clazz.getSuperclass();
		System.out.println(clazz);
		clazz = clazz.getSuperclass();
		System.out.println(clazz);
		clazz = clazz.getSuperclass();
		System.out.println(clazz);
		clazz = clazz.getSuperclass();
		System.out.println(clazz);

	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		String str = new String();
		reflectionExample(str);
	}
}
