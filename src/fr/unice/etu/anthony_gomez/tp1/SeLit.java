package fr.unice.etu.anthony_gomez.tp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SeLit {
	
	// Un commentaire qui doit être ignoré

	static void Lecture(Scanner source) {
		
		while (source.hasNextLine()) {
			
			String s = source.nextLine();
			
			s = s.replaceAll("^[\\s]*\\/\\/.*$","");
			
			System.out.println("LU:"+s);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Demo demo = new Demo();
		
		ArrayList<String> files = demo.exploreReturn(".",new ArrayList<String>(),".java");
		
		for(String fileString : files) {
			
			File file = new File(fileString);
			
			Scanner sc = null;
			
			try {
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			Lecture(sc);
			
		}
	}
	
}
