package Search;

import java.io.File;
import java.util.ArrayList;

public class Ierarhia {
	public static void main(String[] args) {
		ArrayList<File> files = new ArrayList<>();
		String strDir="d:\\";
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