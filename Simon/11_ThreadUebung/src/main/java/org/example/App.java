package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Start Counter" );
        
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        
        t1.start();
        t2.start();
        
        try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        c1.myCancel();
        
        
        try {
			t1.join();
			System.out.println("Summe von " + c1.toString() + " " + c1.getSumme());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        try {
			t2.join();
			System.out.println("Summe von " + c2.toString() + " " + c2.getSumme());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        int gesamtsumme;
        gesamtsumme = c1.getSumme() + c2.getSumme();
        
        System.out.println("Gesamtsumme: " + gesamtsumme);
        System.out.println( "Exit Counter" );
    }
}
