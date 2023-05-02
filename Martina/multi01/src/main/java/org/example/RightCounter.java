package org.example;

public class RightCounter implements Runnable {
	int summeRight;
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			
		    System.out.println("Zahl Right: " + i +" => "+Thread.currentThread().getName());
			
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (stopped == true) {
				break;
			}
			summeRight = summeRight + i;
			
		}
		System.out.println("Summe Right: " + summeRight +" => "+Thread.currentThread().getName());
	
	}
	
	private boolean stopped = false;
	public void cancel() {
		stopped =true;
		
		
		
	}


}
