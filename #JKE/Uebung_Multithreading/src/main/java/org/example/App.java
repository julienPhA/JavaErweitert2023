package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Counter c1 = new Counter(1,10);
    	Counter c2 = new Counter(11,20);
    	Thread t1 = new Thread(c1);
    	Thread t2 = new Thread(c2);
    	t1.start();
    	t2.start();
    	try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	c1.cancel();
    	try {
    		System.out.println("Waiting for thread t2 to end ...");
    		t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Sum counter1 = "+c1.getSum());
    	System.out.println("Sum counter2 = "+c2.getSum());
    }
}
