package action06;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FileSearch{

	private static List<File> list;
	private static AtomicInteger index = new AtomicInteger(0); 
	private static String fileName;
	private static boolean fileFound;
	private static File fileRes;
	
	private static class MyThread extends Thread {
		public void run() {
			
			while (!fileFound && index.get() < list.size()) {
				
				File file = nextFile();
				
				searchFile(file);
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(findFile("D:\\", "1.txt"));
		
	}
	
	public static File findFile(String folderName, String searchedFileName) {
		
		File testFile = new File(folderName);
		if (!testFile.exists() || !testFile.isDirectory()) {
			return null;
		}
		
		list = Collections.synchronizedList(new ArrayList<>());
		fileName = searchedFileName;
		
		boolean searchFinished = false;
		
		fillList(folderName);
		
		Thread[] threads = new Thread[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			threads[i] = new MyThread();
			threads[i].start();
		}
		
		while (!searchFinished) {
			searchFinished = true;
			for (Thread thread : threads) {
				if (thread.isAlive()) {
					searchFinished = false;
				}
			}
		}
		
		return fileRes;
		
	}
	
	private static void fillList(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			list.addAll(Arrays.asList(file.listFiles()));
		}
	}
	
	private static synchronized File nextFile() {
		File file = list.get(index.getAndIncrement());
		return file;
	}
	
	private static void searchFile(File file) {
		
		List<File> subList = new ArrayList<>();
		
		if (file == null) {
			return;
		}
		
		if (file.isDirectory()) {
			
			File[] files = file.listFiles();
			
			if (files != null) {
				subList.addAll(Arrays.asList(files));
				
				for (File fl : subList) {
					if (!fileFound) {
						searchFile(fl);
					}
				}
			}

		}
		else if (file.getName().equals(fileName)){
			fileFound = true;
			fileRes = file;
		}
		
	}
}
