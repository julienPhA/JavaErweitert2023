package de.lbbw.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactoryImpl {
	
	public ObjectFactoryImpl() {		
	}

	public Object create(String classname) {
		
		Object o = null;
		Class<?> clazz;
		
		try {
			clazz = Class.forName(classname);
			System.out.println("Klassennamen: " + clazz.getName());
			
			Constructor<?> ctor = clazz.getConstructor();
			System.out.println("Konstruktor: " + ctor.getName());
			
			o = ctor.newInstance();
			System.out.println(o.toString());
			
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println("Keine Definition der Klasse <" + classname + "> gefunden.");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err.println("Die Klasse <" + classname + "> ist nicht für eine Instanziierung erlaubt.");
			e.printStackTrace();
		}
			
		return o;
	}

	public Object create(String classname, String type, int brennwert) {
		
		Object o = null;
		
		try {
			Class<?> clazz = Class.forName(classname);
			System.out.println("Klassennamen: " + clazz.getName());
			
			Constructor<?> ctor = clazz.getConstructor(String.class, int.class);
			System.out.println("Konstruktor: " + ctor.getName());
			
			o = ctor.newInstance(type, brennwert);
			System.out.println(o.toString());
			
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return o;	
	}

	public Object create(String classname, int brennwert) {
		
		Object o = null;
		
		try {
			Class<?> clazz = Class.forName(classname);
			System.out.println("Klassennamen: " + clazz.getName());
			
			Constructor<?> ctor = clazz.getConstructor(int.class);
			System.out.println("Konstruktor: " + ctor.getName());
			
			o = ctor.newInstance(brennwert);
			System.out.println(o.toString());
			
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return o;	
	}

	
	
}
