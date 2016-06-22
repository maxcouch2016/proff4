package action06;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MySeatch {
	private static String startDir = "E:/JavaTrend/Java/test"; // temp
	private static String startFile = "test"; // temp
	private static List<File> list;

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// System.out.println("Выберите директорию: ");
		// startDir= scan.nextLine();
		// System.out.println("Введи имя файла ");
		// startFile = scan.nextLine();

		findFile(startDir, startFile); // просим найти файл

	}

	private static File findFile(String startDir2, String startFile2) {
		// проверяем есть ли такая директория
		File testFile = new File(startDir2);
		if (!testFile.exists() || !testFile.isDirectory()) {
			System.out.println("Нет такой директории");
			return null;
		}
		
		
		

		fillList(startDir2); // заполняем лист всеми папками внутри

		Thread[] threads = new Thread[list.size()]; // создаем масив потоков на
													// основе количества папок

		for (int i = 0; i < list.size(); i++) { // запускаем все потоки
			threads[i] = new MyThread();
			threads[i].start();
		}
		
		// каждый поток должен отработать и закрыться
		boolean searchFinished = false;
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

	private static class MyThread extends Thread {
		public void run() {

		}
	}

}
