package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void demoThreading() {
        System.out.println( "Enter demoThreading on thread "+Thread.currentThread().getName() );
        LeftRunnable leftRunnable = new LeftRunnable();
        RightRunnable rightRunnable = new RightRunnable();
        Thread t1 = new Thread(leftRunnable);
        Thread t2 = new Thread(rightRunnable);
        t1.start();
        t2.start();
        
        leftRunnable.stop();
        
        System.out.println("Waiting for thread t1 to end on thread "+Thread.currentThread().getName());
        try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Waiting for thread t2 to end on thread "+Thread.currentThread().getName());
        try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println( "Exit demoThreading on thread "+Thread.currentThread().getName() );
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Enter main on thread "+Thread.currentThread().getName() );
        demoThreading();
        System.out.println( "Exit main on thread "+Thread.currentThread().getName() );
    }
}
