package de.lbbw.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import de.lbbw.global.Brennbar;



public class ObjectFactory{
	
	public Object createString(String className) throws ClassNotFoundException {

		Constructor<?> ctor;
		Object obj = null;
		try {
			Class<?> clazz = Class.forName(className);
			
			ctor = clazz.getConstructor();
			obj = ctor.newInstance();
			System.out.println("Object created : "+obj.toString());		

		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return obj;

	}
	
	public Object createString(String className, String type) {
		Constructor<?> ctor;
		Object obj = null;
		Class<?> clazz;
		try {
			clazz = Class.forName(className);
			ctor = clazz.getConstructor(String.class);
			obj = ctor.newInstance(type);
			System.out.println("Object created : "+obj.toString());		
			//System.out.println("Object created : "+obj.toString());		

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return obj;
	
	}

}
