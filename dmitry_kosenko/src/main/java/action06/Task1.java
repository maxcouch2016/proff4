package action06;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 extends Thread{
 private static List<Object> list;
 public static void main(String[] args) {
  list = Collections.synchronizedList(new ArrayList<>());
  for(int i=0;i<10;i++){  
   new Task1().start();
  } 
 }
 @Override
 public void run() {
  for(int i=0;i<1000;i++){
  list.add(i);
  System.out.println(Thread.currentThread().getName() + "_" + list.size());}
 }

}