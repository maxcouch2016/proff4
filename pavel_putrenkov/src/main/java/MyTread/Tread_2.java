/*Задача 2. Написать метод, паралельного поиска файла в заданной папке.
 Метод принимает имя папки и искомый файл.
 Если метод нашел файл, то возвращает полный путь к файлу, иначе возвращает пустую строку.
 Метод поиска формирует список файлов(директорий поиска) и переменную индекса, соответствующая 
 свободной директори для поиска.
 Передать этот список нескольким потокам, которые будут обрабатывать его и обновлять эту переменную индекса.*/
package MyTread;

import java.io.File;
import java.util.ArrayList;

public class Tread_2 {
	public static void main(String[] args) {
		ArrayList<File> files = new ArrayList<>();
		String strDir="d://";
		File dir = new File(strDir);
		files.add(dir);	
			for (int i = 0;i<files.size();i++) {
			File f = files.get(i);
			if(f.isDirectory()){
				 File[] arr = f.listFiles();
				 if(arr==null)System.out.println("f="+f);
				 for(int j=0;j<arr.length;j++){
					 files.add(arr[j]);

			}
						
		}		
			System.out.println(files);
			
			}
		}
}
