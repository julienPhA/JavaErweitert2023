package de.lbbw;

public class CounterRunnable implements Runnable {

	private int summe;
	private boolean stopped = false;
	
	// synchronized = ein anderer Thread kann nur darauf zugreifen wenn der andere fertig ist 
	//public synchronized void counter() {
	public void counter() {
				
		for (int i = 1; i<=10;i++) {
			System.out.println(i);
			summe= summe +i;
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(stopped==true) {
				// eventuell Ressourcen hier freigeben
				break;
			}
		}
	}
	
	
	public void stop() {
		
		stopped = true;
	}
	
	@Override
	public void run() {
		counter();
	}

	public int getSumme() {
		return summe;
	}

}
