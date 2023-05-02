
public class Counter implements Runnable {

private boolean stopped = false;
	
	private int anzahl;
	
	public void stoppeThread() {
		stopped = true;
	}

	@Override
	public void run() {
		System.out.println("Run Counter on thread "+Thread.currentThread().getName());
		counter();
		System.out.println("Exit run Counter on thread "+Thread.currentThread().getName());
		
	}
	
	public void counter() {
		int i;
		for (i = 0; i < 10; i++) {			
			System.out.println("Zahl : " +i +" on Thread " +Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(stopped == true) {
				// evtl. Ressourcen wieder freigeben
				break;
			}
		}
		anzahl = i;
	}

	public int getAnzahl() {
		return anzahl;
	}
	
}
