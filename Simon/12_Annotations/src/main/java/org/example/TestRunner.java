package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

	private Object objectToTest = null;
	
	public TestRunner(Object objectToTest) {
		super();
		this.objectToTest = objectToTest;
	}

	public void run() {
		System.out.println("Start TestRunner.run() ....");
		Class<?> clazz = objectToTest.getClass();
		for(Method m : clazz.getMethods()) {
			System.out.println("Found method: " + m.getName());
			Test annotation = m.getAnnotation(Test.class);
			
			if (annotation != null) {
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
		System.out.println("Exit TestRunner.run() ....");
	}

}
