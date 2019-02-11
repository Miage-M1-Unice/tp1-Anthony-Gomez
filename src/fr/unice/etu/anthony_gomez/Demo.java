package fr.unice.etu.anthony_gomez;

import java.io.File;

public class Demo {

	public static void main(String[] args) {
		explore(".");
	}
	
	public static void explore(String path) {
		File reporitory = new File(path);
		File[] list = reporitory.listFiles();
		
		for (File file : list) {
			if(file.isDirectory()) {
				explore(file.getPath());
			}
			System.out.println(file.toString());
		}
	}

}