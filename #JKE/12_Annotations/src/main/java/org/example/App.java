package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TestRunner runner = new TestRunner(new PersonTest());
        runner.run();
    }
}
