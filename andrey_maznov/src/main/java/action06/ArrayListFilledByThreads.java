package action06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Задача 1. 10 потоками заполнить ArrayList, 
 каждый из потоков добавляет по 1000 элементов от 1 до 1000.
 В результате должно быть 10000 элементов.
*/

public class ArrayListFilledByThreads extends Thread{

	private static List<Integer> list;
	
	public static void main(String[] args) {
		
		list = Collections.synchronizedList(new ArrayList<>());
		
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new ArrayListFilledByThreads());
			t.start();
		}
		
	}
	
	public void run() {
		
		for (int i = 1; i < 1001; i++) {
			list.add(i);
			System.out.println(Thread.currentThread().getName() + "_" + list.size());
		}
		
	}
	
}
