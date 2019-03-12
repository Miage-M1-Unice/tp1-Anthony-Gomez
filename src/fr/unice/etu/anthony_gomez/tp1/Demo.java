package fr.unice.etu.anthony_gomez.tp1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.explore(".");
	}

	public void explore(String path) {
		File reporitory = new File(path);

		FilenameFilter filenameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				boolean isAccept = false;
				File file = new File(dir+"\\"+name);

				if (file.isDirectory()) {
					isAccept = true;
				}

				else if(name.toLowerCase().endsWith(".java")) {
					isAccept = true;
				}

				return isAccept;
			}
		};

		File[] list = reporitory.listFiles(filenameFilter);

		for (File file : list) {
			if(file.isDirectory()) {
				explore(file.getPath());
			}
			else {
				System.out.println(file.toString());
			}
		}
	}
	
	public  ArrayList<String> exploreReturn(String path, ArrayList<String> filesStorage, String filtre) {
		
		File reporitory = new File(path);

		FilenameFilter filenameFilter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {

				boolean isAccept = false;
				File file = new File(dir+"\\"+name);

				if (file.isDirectory()) {
					isAccept = true;
				}

				else if(name.toLowerCase().endsWith(filtre)) {
					isAccept = true;
				}

				return isAccept;
			}
		};

		File[] list = reporitory.listFiles(filenameFilter);

		for (File file : list) {
			if(file.isDirectory()) {
				exploreReturn(file.getPath(),filesStorage,filtre);
			}
			else {
				
				filesStorage.add(file.toString());
				
			}
		}
		return filesStorage;
	}

}