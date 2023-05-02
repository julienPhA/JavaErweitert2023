package de.lbbw;

public class Freds implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this + " " + Thread.currentThread().getName());
	}
	
}