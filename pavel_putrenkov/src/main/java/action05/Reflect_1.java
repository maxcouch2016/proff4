/*Задача1: Вывести все методы класса String*/
package action05;

import java.lang.reflect.Method;

public class Reflect_1 {
public static void main(String[] args) {
		for(Method csd:String.class.getMethods()){
			System.out.println(csd);
		}	
	}
	}
