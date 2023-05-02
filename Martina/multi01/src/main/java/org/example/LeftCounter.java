package org.example;

public class LeftCounter implements Runnable {
	
	
	
	int summeLeft ;
	@Override
	public void run() {
		

		for (int i = 1; i < 11; i++) {

			System.out.println("Zahl Left; " + i +" => "+Thread.currentThread().getName());
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
			summeLeft = summeLeft + i;
		}
		
		
		
		System.out.println("Summe Left: " + summeLeft +" => "+Thread.currentThread().getName());

	}
	
	private boolean stopped = false;
	public void cancel() {
		stopped =true;
		
		
		
	}

}
