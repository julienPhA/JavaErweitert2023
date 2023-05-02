package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
	
	private Object objectToTest = null;
	
	public TestRunner(Object objectToTest) {
		this.objectToTest = objectToTest;
	}
	
	public void run() {
		System.out.println("Start TestRunner.run() ... ");
		// Schritt #1 verwende Reflection und deshalb 
		// das Class object der zu testenden Klasse
		Class<?> clazz = objectToTest.getClass();
		System.out.println("name: "+clazz.getName());
		// Schritt #2 : ermittle alle Methoden der zu testenden Klasse
		for(Method m : clazz.getMethods()) {
			System.out.println("Found method: "+m.getName());
			Test annotation = m.getAnnotation(Test.class);
			if(annotation != null) {
				try {
					m.invoke(objectToTest);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
 		System.out.println("Exit TestRunner.run() ... ");
	}
}
