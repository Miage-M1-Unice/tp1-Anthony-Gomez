package fr.unice.etu.anthony_gomez.tp3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.security.SecureClassLoader;
import java.util.ArrayList;

public class MyClassLoader extends SecureClassLoader {
	
	private ArrayList<File> path = null;
	
	public MyClassLoader(ArrayList<File> p) {  
	   this.path = p;  
	 }
	
	@Override  
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		 byte[] b = loadClassData(name);  
		 return super.defineClass(name, b, 0, b.length);  
	 }  
	   
	 private byte[] loadClassData(String name) throws ClassNotFoundException {
		 
		 byte[] classData = null;
		 
		 //  parcourir chaque chemin dans la liste path
		 for (int i = 0; i < this.path.size(); i++) {
			String urlPath = this.path.get(i).getAbsolutePath()+"/"+name.replace(".", "/");
			
			File file = new File(urlPath);
			
			if(file.exists()) {
				try {
					classData = Files.readAllBytes(file.toPath());
				} catch (IOException e) {
					throw new ClassNotFoundException();
				}
			}
		}
		 
		 return classData;  
	 }  
	  
	 public static void main(String[] args) {
		 
		 ArrayList<File> al = new ArrayList<File>();  
		 String url = "file:///D:/ganth/Documents/Pro/M1 MIAGE/Programmation avancée/bin/fr/unice/etu/anthony_gomez/tp1";
		 
		 File f = new File(url);
		 if(f.isDirectory()) {
			 al.add(f);
		 }
		 
		 
		 MyClassLoader myCl = new MyClassLoader(al);
		   
		   try {  
		    Class<?> cl = myCl.loadClass("fr.unice.etu.anthony_gomez.tp1.Demo");
		    
		    Method[] methods = cl.getDeclaredMethods();
		    
		    for (Method method : methods) {
				System.out.println(method.getName());
			}
		    
		   }
		   catch (ClassNotFoundException e) {  
			  e.printStackTrace();
		   }  
	 }  
} 
