package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnnotation
public class ReflectionApi {
	 
	@MyAnnotation
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ReflectionApi obj = new ReflectionApi();

		Class<?> cl = obj.getClass();
 
		ReflectionApi obj1 = (ReflectionApi)cl.newInstance();

		// my comment
		Field[] fields = cl.getFields();
		Field f;
		
		cl.getDeclaredFields();
		
		Method[] methods = cl.getMethods();
		cl.getDeclaredMethods();
		
		cl.getInterfaces();  
		cl.getSuperclass();
		
		methods[0].isAnnotationPresent(MyAnnotation.class);
 	}	
}

@interface MyAnnotation {

} 
