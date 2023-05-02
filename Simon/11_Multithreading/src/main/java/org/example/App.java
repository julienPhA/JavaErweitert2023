package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void demoThreading() {
        System.out.println( "Enter demoThreading on thread "+ Thread.currentThread().getName() );
        
        LeftRunnable lr = new LeftRunnable();
        RightRunnable rr = new RightRunnable();
        
        Thread t1 = new Thread(lr);
        Thread t2 = new Thread(rr);
        
        t1.start();
        t2.start();
        
        lr.stop();
        
        System.out.println("Waiting for tread t1 to end ...");
        
        try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        System.out.println("Waiting for tread t2 to end ...");
        
        try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
        System.out.println( "Exit demoThreading on thread "+ Thread.currentThread().getName() );
		
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Enter main on thread "+ Thread.currentThread().getName() );
        demoThreading();
        System.out.println( "Exit main on thread "+ Thread.currentThread().getName() );
    }
}
