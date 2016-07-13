package Search;

import java.io.File;


public class FileExample {
 public static void main(String[] args) throws Exception{
  System.out.println(File.separatorChar);
  System.out.println(File.separator);
  String s = "�������� \"name\" = \"Poll\"";
  System.out.println(s);
  File file1 = new File("c:\\work\\example.tXt");
  System.out.println("file1.createNewFile()="+file1.createNewFile());
  
  File file2 = new File("c:/work/temp1/temp2");
  System.out.println("file2.mkdir()="+file2.mkdir());
  //file2.mkdirs();
  
  System.out.println();
  System.out.println("getAbsolutePath()="+file1.getAbsolutePath());
  System.out.println("getCanonicalPath()="+file1.getCanonicalPath());
  System.out.println("getName()="+file1.getName());
  System.out.println("getPath()="+file1.getPath());
  
  System.out.println();
  File dir = new File("c:\\work");
  if(dir.isDirectory()){
   File[] arr = dir.listFiles();
   for(File f: arr){
    System.out.println(f.getName());
   }
 
   File f = arr[0];
   System.out.println("f="+f.getName());
  }  
 }
}
