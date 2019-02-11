package fr.unice.etu.anthony_gomez;

import java.io.File;
import java.io.FilenameFilter;

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
				
				// TODO Auto-generated method stub
				if(dir.isDirectory() || name.toLowerCase().endsWith(".java") )  {
					if(name.toLowerCase().endsWith(".java")) {
						System.out.println("is accepted : "+dir.toString()+"\\"+name);
					}
					
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
		}
	}

}