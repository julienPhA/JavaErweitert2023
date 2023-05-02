package org.example;


public class App{

public static void counter() {
		System.out.println("Enter counter on thread " + Thread.currentThread().getName());
		
		
		LeftCounter leftcounter = new LeftCounter();
		RightCounter rightcounter = new RightCounter();
		Thread t1 = new Thread(leftcounter);
		Thread t2 = new Thread(rightcounter);

		t1.start();
		t2.start();
		
		try {
			Thread.currentThread();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		leftcounter.cancel();
		
		System.out.println("Exit counter thread " + Thread.currentThread().getName());
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void main(String[] args) {
		System.out.println("Enter main on thread " + Thread.currentThread().getName());
		counter();
		System.out.println("Exit main on thread " + Thread.currentThread().getName());
	}
}
