package fr.unice.etu.anthony_gomez.tp2;

/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
    // Récupération d'un objet de type Class correspondant au nom passé en paramètres
    Class<?> cl = getClasse(nomClasse);

    afficheEnTeteClasse(cl);

    System.out.println();
    afficheAttributs(cl);

    System.out.println();
    afficheConstructeurs(cl);

    System.out.println();
    afficheMethodes(cl);

    // L'accolade fermante de fin de classe !
    System.out.println("}");
  }


  /** Retourne la classe dont le nom est passé en paramètre */
  public static Class<?> getClasse(String nomClasse) throws ClassNotFoundException {
	  return Class.forName(nomClasse);
  }

  /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public static void afficheEnTeteClasse(Class<?> cl) {
    //  Affichage du modifier et du nom de la classe
	int m = cl.getModifiers();
	String modifier = "";
	
	if(Modifier.isPrivate(m)) {
		modifier = "private";
	}
	else if (Modifier.isPublic(m)) {
		modifier = "public";
	}
	else if (Modifier.isProtected(m)) {
		modifier = "protected";
	}
	
    System.out.println("Modifier : "+modifier);
    System.out.println("Nom de la classe: "+cl.getName());

   // Récupération de la superclasse si elle existe (null si cl est le type Object)
    Class<?> supercl = cl.getSuperclass();// CODE A ECRIRE

    // On ecrit le "extends " que si la superclasse est non nulle et
    // différente de Object
    // CODE A ECRIRE
    if((supercl != null) && (supercl.getName() != "Object")) { 
    	System.out.println("extends ");
    }

    // Affichage des interfaces que la classe implemente
    // CODE A ECRIRE
    System.out.println("Interfaces :");
    Class<?>[] interfaces = cl.getInterfaces();
    for (Class<?> interfac : interfaces) {
		System.out.println(interfac);
	}
    
    // Enfin, l'accolade ouvrante !
    System.out.print(" {\n");
  }

  public static void afficheAttributs(Class<?> cl) {
    Field[] fields = cl.getFields();
    for (Field field : fields) {
		System.out.println(field);
	}
  }

  	public static void afficheConstructeurs(Class<?> cl) {
    // CODE A ECRIRE
	  Constructor<?>[] constructors = cl.getConstructors();
	  for (Constructor<?> constructor : constructors) {
		System.out.println(constructor);
	  }
    }

  public static void afficheMethodes(Class<?> cl) {
    // CODE A ECRIRE
	  Method[] methods = cl.getMethods();
	  for (Method method : methods) {
		System.out.println(method);
	}
    }

  public static String litChaineAuClavier() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
  }

  public static void main(String[] args) {
    boolean ok = false;

    while(!ok) {
      try {
        System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        String nomClasse = litChaineAuClavier();

        analyseClasse(nomClasse);

        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvée.");
      }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }
    }
  }
}
