package de.lbbw.hkw.util;

import java.lang.reflect.InvocationTargetException;

public class ObjectFactoryImpl {
	
	public ObjectFactoryImpl() {
		System.out.println("ObjectFactory erzeugt");
	}
	
	public Object create (String classname) {
		Object object = null;
		Class<?> clazz;
		try {
			clazz = Class.forName(classname);
			object = clazz.getConstructor().newInstance();
			System.out.println("ObjectFactory : Objekt vom Typ "+object.getClass().getName()+" erzeugt");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			System.out.println("ObjectFactory: cannot create object: "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
		return object;
	}
	public Object create (String classname, String type) {
		Object object = null;
		Class<?> clazz;
		try {
			clazz = Class.forName(classname);
			object = clazz.getConstructor(String.class).newInstance(type);
			System.out.println("ObjectFactory : Objekt vom Typ "+object.getClass().getName()+" erzeugt: " + type);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			System.out.println("ObjectFactory: cannot create object: "+e.getClass().getSimpleName()+" "+e.getMessage());
		}
		return object;
	}
}
