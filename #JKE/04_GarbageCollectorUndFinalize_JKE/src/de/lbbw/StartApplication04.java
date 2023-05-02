package de.lbbw;

public class StartApplication04 {

	public static void createObjects() {
		System.out.println("Enter createObjects");
		Person p1 = new Person(101,"Gosling");
		Person p2 = new Person(102,"Ritchie");
		Person p3 = new Person(100,"Stroustrup");
		System.out.println("Exit createObjects");
	}
	
	public static void main(String[] args) {
		System.out.println("Enter main on thread "+Thread.currentThread().getName());
		createObjects();
		System.gc();
		System.out.println("Exit main on thread "+Thread.currentThread().getName());
	}

}
