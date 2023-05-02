package de.lbbw.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {

	public Object create(String classname) {

		Class<?> clazz;
		Constructor<?> csr;
		Object object = null;
		
		System.out.println("Neues Object erzeugen: " + classname);
		
		try {
			clazz = Class.forName(classname);
			csr = clazz.getConstructor();
			object = csr.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
				
		return object;
	}
	
public Object create(String classname, String type) {
		
	Class<?> clazz;
	Constructor<?> csr;
	Object object = null;
		
		System.out.println("Neues Object erzeugen: " + classname);
	
		try {
			clazz = Class.forName(classname);
			csr = clazz.getConstructor(String.class);
			object = csr.newInstance(type);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
				
		return object;
	}

public Object create(String classname, String type, int brennwert) {
	
	Class<?> clazz;
	Constructor<?> csr;
	Object object = null;
	
	System.out.println("Neues Object erzeugen: " + classname);
		try {
			clazz = Class.forName(classname);
			csr = clazz.getConstructor(String.class, int.class);
			object = csr.newInstance(type, brennwert);
		} catch (ClassNotFoundException e) {
			System.out.println("Class " + classname + " ist nicht bekannt.");
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
				
		return object;
	}
}