package de.lbbw;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class StartApp06 {

	public static void createObjectFromString(String classname) {
		
		System.out.println("ENTER createObjectFromString");
		
		try {
			Class<?> clazz = Class.forName(classname);
			System.out.println(clazz.getSimpleName());
			
			Constructor<?> ctor;
			try {
				ctor = clazz.getConstructor();
				Object object = ctor.newInstance();
				System.out.println("Created: " + object.toString());
				
				Person p = (Person) object;
				
				System.out.println(p.getName());
				
				//ctor = clazz.getConstructor(int.Class, String.class);
				//p= (Person)ctor.newInstance(100, "Gosling");
				
				
				
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
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// get Packages
//		for (Package pg : Package.getPackages()) {
//			System.out.println(pg.getName());
//		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Starte Holzkraftwerk-Application");
				
		Scanner scanner = new Scanner(System.in);
		
		String classname = "de.lbbw.Person";
		
		while (true) {
			System.out.println("Enter classname");
			classname = scanner.nextLine();
			
			if (classname.equals("EXIT")) {
				break;
			} else {
				createObjectFromString(classname); // "de.lbbw.Person"
			}
		}
						
		System.out.println("Beende Holzkraftwerk-Application");
	}
}
