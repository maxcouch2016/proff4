/*Задача 1. 
 10 потоками заполнить ArrayList, 
 каждый из потоков добавляет по 1000 элементов от 1 до 1000.
 В результате должно быть 10000 элементов.*/
package MyTread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tread_1 extends Thread{
	private static List<Integer> list;
	public static void main(String[] args) {
		list = Collections.synchronizedList(new ArrayList<>());
		for(int i=0;i<10;i++){	 
			new Tread_1().start();
		}	
	}
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
		list.add(i);
		System.out.println(Thread.currentThread().getName() + "_" + list.size());}
	}

}
