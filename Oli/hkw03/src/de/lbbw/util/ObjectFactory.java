package de.lbbw.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import de.lbbw.brennelemente.Holz;

public class ObjectFactory {

	public Object create(String className) {
		
		Object object = null;
		
		// Schritt 1 : ermittle das class Object zum Namen der Klasse
		try {
			Class<?> clazz = Class.forName(className);
			// Schritt 2 : ermittle mit Hilfe des clazz objects einen Konstruktor der Klasse
						//             -> hier wird der default-Konstruktor ermittelt
			Constructor<?> ctor = clazz.getConstructor();
			// Schritt 3 : erzeuge ein Objekt der ermittelten Klasse mit Hilfe des Default-Konstruktors
			object = ctor.newInstance();
			System.out.println("Object created : "+object.getClass().getName());
						
					
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	public Object create(String className, String type, int bw) {
		
		Object object = null;
		
		// Schritt 1 : ermittle das class Object zum Namen der Klasse
		try {
			Class<?> clazz = Class.forName(className);
			// Schritt 2 : ermittle mit Hilfe des clazz objects einen Konstruktor der Klasse
			// verwende nun zum Erzeugen eines Objekts den 2-argument Konstruktor			//             
			Constructor<?> ctor = clazz.getConstructor(String.class, int.class);
			object = ctor.newInstance(type, bw);
			System.out.println("Object created : "+object.getClass().getName());
					
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
