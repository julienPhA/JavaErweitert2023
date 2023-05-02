package org.example;

public class Counter implements Runnable {

	private boolean stopped = false;
	private int summe;
	
	public void myCancel() {
		stopped = true;
	}
	
	@Override
	public void run() {
		counter();
	}
	
	//public void synchronized xy() {	}
	
	
	public void counter() {
		int i;
		
		for (i = 0; i < 10; i++) {
			System.out.println("Mein Counter ist <" + i + "> auf " + Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			if (this.stopped == true) {
				break;
			}
		}
		
		this.summe = i;
	}

	// Setters
	
	public int getSumme() {
		return summe;
	}
	
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}


}
