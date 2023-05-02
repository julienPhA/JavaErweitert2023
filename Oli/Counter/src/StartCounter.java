
public class StartCounter {

	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		t1.start();
		t2.start();
		try {
			Thread.currentThread().sleep(3000);
			c1.stoppeThread();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Anzahl Zeilen for thread t1 ausgegeben: " +c1.getAnzahl());
		System.out.println("Anzahl Zeilen for thread t2 ausgegeben: " +c2.getAnzahl());
		
	}

}
