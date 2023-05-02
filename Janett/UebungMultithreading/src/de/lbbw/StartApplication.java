package de.lbbw;

public class StartApplication {

	public static void main(String[] args) {
		
		CounterRunnable c1 = new CounterRunnable();
		CounterRunnable c2 = new CounterRunnable();
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
		
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c1.stop();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Summe fuer Thread 1: " + c1.getSumme());
		System.out.println("Summe fuer Thread 2: " + c2.getSumme());
	}

}

