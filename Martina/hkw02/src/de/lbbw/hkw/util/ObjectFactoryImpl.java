package de.lbbw.hkw.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectFactoryImpl {

	public Object create(String classname) {
		Object object = null;
		try {
			Class<?> clazz = Class.forName(classname);
		
			Constructor<?> ctor = clazz.getConstructor();
			
			object = ctor.newInstance();
			System.out.println("Brennmaterial gewaehlt : "+object.getClass().getName());
		
			//Holz h = (Holz)object;
		
			//System.out.println("Object of type Person created: "+object.toString());
		
			//ctor = clazz.getConstructor(int.class,String.class);
			//h = (Holz)ctor.newInstance("Buche");
			//System.out.println("Object of type Person created: "+h.getTyp()+" "+h.getBrennwert());
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
		
		return object;
	}
	public Object create(String classname, String type) {
		return classname;
	}
	

}
