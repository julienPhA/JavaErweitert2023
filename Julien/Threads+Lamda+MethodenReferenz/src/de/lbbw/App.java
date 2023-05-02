package de.lbbw;

public class App {

	public static void main(String[] args) {
		//Threads als eigene Klasse > implements Runnable
		Thread f1 = new Thread(new Freds());
		Thread f2 = new Thread(new Freds());
		f1.start();
		f2.start();

		new Thread( () -> System.out.println("T1 " + Thread.currentThread().getName()) ).start();
		new Thread( () -> System.out.println("T2 " + Thread.currentThread().getName()) ).start();
		
		//Threads als Methodenreferenz
		new Thread( App::prozesse ).start();
		new Thread( App::prozesse ).start();
		new Thread( App::prozesse ).start();
		
		
/*		
		try {
			f1.join();
			f2.join();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		System.out.println("Exit main");
	}
	
	/**
	 * Methode die parallelisiert wird
	 */
	public static void prozesse() {
		System.out.println("Prozess auf " + Thread.currentThread().getName());
	}
}