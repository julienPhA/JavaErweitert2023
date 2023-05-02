package de.lbbw;

public class StartApplication {

	public static void main(String[] args) {
		System.out.println("Enter main on thread "+Thread.currentThread().getName());
		Thread t1 = new Thread (new Logger());
		t1.setName("T1");
		Thread t2 = new Thread (new Logger());
		t2.setName("T2");
		Thread t3 = new Thread (new Logger());
		t3.setName("T3");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Exit main on thread "+Thread.currentThread().getName());
	}

}
