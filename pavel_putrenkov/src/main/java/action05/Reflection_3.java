package action05;

import java.util.ArrayList;

public class Reflection_3 {
	public static <T> void main(String[] args) {
		ArrayList<T> list =new ArrayList<T>();
		for(Class<?> csd:list.getClass().getInterfaces()){
			System.out.println(csd);
		}	
	}
}
