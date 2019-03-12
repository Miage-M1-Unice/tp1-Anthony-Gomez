package fr.unice.etu.anthony_gomez.tp1;

import java.io.File;
import java.io.FilenameFilter;

public class Filter {
	
	private FilenameFilter filter;
	
	public Filter(String filtre){
		
		this.filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				boolean isAccept = false;
				
				if(dir.isDirectory() || name.toLowerCase().endsWith(filtre) )  {
					if(name.toLowerCase().endsWith(filtre)) {
						System.out.println(dir.toString()+"\\"+name);
					}
					
					isAccept = true;
				}
				
				return isAccept;
			}
		};
	}
	
	public FilenameFilter getFilter() {
		return this.filter;
	}

}
