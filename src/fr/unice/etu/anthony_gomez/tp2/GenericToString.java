package fr.unice.etu.anthony_gomez.tp2;

import java.awt.Point;
import java.awt.Polygon;
import java.lang.reflect.Field;

public class GenericToString {
	
   public String toString(Object object) {
	   
       String fieldsStr = object.getClass().getName() + "[";
       
       Class<?> classe = null;

       try {
           classe = Class.forName(object.getClass().getName());
       }
       catch (ClassNotFoundException e) {
           e.printStackTrace();
       }

       Field[] fields = classe.getDeclaredFields();

       for(int i=0; i<fields.length; i++) {
           fields[i].setAccessible(true);

           try {
               fieldsStr += fields[i].getName() + "=" + fields[i].get(object);
           }
           catch (IllegalArgumentException e) {
               e.printStackTrace();
           }
           catch (IllegalAccessException e) {
               e.printStackTrace();
           }

           if(i<fields.length -1) {
               fieldsStr +=  ";" ;
           }else {
               fieldsStr += ']';
           }

       }

       return fieldsStr;
   }

   public String toString(Object object, int i) {


       String str = object.getClass().getName() + "[";
       String alt = "";

       Class<?> classe = null;

       try {
           classe = Class.forName(object.getClass().getName());
       }
       catch (ClassNotFoundException e) {
           e.printStackTrace();
       }

       Field[] fields = classe.getDeclaredFields();

       for(int j=0; j<fields.length; j++) {
           fields[j].setAccessible(true);

           try {
               if(fields[j].get(object) instanceof  int[]) {
                   alt = "";
                   int[] inte = (int[]) fields[j].get(object);

                   String separator = "";
                   for(int z=0; z<inte.length; z++) {
                       if(z < 2) {
                           separator = ";";
                       }else {
                           separator = "";
                       }

                       alt += inte[z] + separator;
                   }
               }
               if(j>0 && j<3) {
                   str += fields[j].getName() + "={" + alt + "}";
               }else {
                   str += fields[j].getName() + "=" + fields[j].get(object) ;
               }

           }
           catch (IllegalArgumentException e) {
               e.printStackTrace();
           }
           catch (IllegalAccessException e) {
               e.printStackTrace();
           }

           if(j<fields.length -1) {
               str +=  ";" ;
           }else {
               str += ']';
           }

       }

       return str;
   }
   
   static public void main(String[] args) {  
	   System.out.println(new GenericToString().toString(new Point(12,24)));  
	   
	   Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);  
	   pol.getBounds();  
	   System.out.println(new GenericToString().toString(pol, 2));  
	 } 
}