package de.lbbw;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class StartApplication06 {

	/**
	 * demonstriert den Umgang mit dem Reflection API
	 * anhand der Klasse java.util.Class
	 * @param className
	 */
	public static void createObjectFromString(String className) {
		// Schritt 1 : ermittle das class Object zum Namen der Klasse
		try {
			Class<?> clazz = Class.forName(className);
			// Schritt 2 : ermittle mit Hilfe des clazz objects einen Konstruktor der Klasse
			//             -> hier wird der default-Konstruktor ermittelt
			Constructor<?> ctor = clazz.getConstructor();
			// Schritt 3 : erzeuge ein Objekt der ermittelten Klasse mit Hilfe des Default-Konstruktors
			Object object = ctor.newInstance();
			System.out.println("Object created : "+object.toString());
			// Schritt 4 : versuche, das objekt auf ein gewünschtes Interface zu casten
			Person p = (Person)object;
			// jetzt kann sinnvoll mit dem erzeugten Objekt gearbeitet werden, denn sein Typ ist bekannt
			System.out.println("Object of type Person created: "+p.getName());
			// verwende nun zum Erzeugen eines Objekts den 2-argument Konstruktor
			// mit den Argumenten int und String
			ctor = clazz.getConstructor(int.class,String.class);
			p = (Person)ctor.newInstance(100,"Gosling");
			System.out.println("Object of type Person created: "+p.getNr()+" "+p.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// herkömmliche Art und Weise, ein Objekt zu erstellen
		// hier ist der Typname zur Compilezeit bekannt
		Kunde p = new Kunde(100,"Gosling");
		// lese den Typnamen zur Laufzeit(!) ein
		Scanner scanner = new Scanner(System.in);
		String classname = "";
		while(true) {
			System.out.print("Enter classname: ");
			classname = scanner.nextLine();
			if(classname.equals("EXIT")) {
				break;
			} else {
				createObjectFromString(classname);
			}
		}
	}

}
