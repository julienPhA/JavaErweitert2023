package org.example;

public class LeftRunnable implements Runnable {

	private boolean stopped = false;
	
	public void stop() {
		stopped = true;
	}
	
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Left runnable on thread " + Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (stopped = true) {
				break;				
			}
		}
		
	}
		
}
