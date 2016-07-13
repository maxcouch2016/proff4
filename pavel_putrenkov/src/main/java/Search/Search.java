/*Task1. ��������� � ������� ���� ����� � ����������. 
 ������� �� ����� ��� ����� � ���������� �� ���� �����.*/
package Search;

import java.io.File;

public class Search {
public static void main(String[] args) {
	 File file1 = new File("F:\\����\\��������");
	 System.out.println("getAbsolutePath()="+file1.getAbsolutePath());
	 System.out.println("getName()="+file1.getName());
	 File dir = new File("F:\\����\\��������");
	  if(dir.isDirectory()){
	   File[] arr = dir.listFiles();
	   for(File f: arr){
	    if(f.getName().indexOf("JPG")>-1){System.out.println(f.getName());}
	   }
}
}
}