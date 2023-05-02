package org.example;

public class PersonTest {
	
	@Test
	public void isNrCorrect() {
		Person p  = new Person(100,"Stroustrup");
		if(p.getNr()!=100) {
			System.out.println("Test failed");
		} else {
			System.out.println("Test OK");
		}
		
	}
	
	public void otherMethod() {
		System.out.println("other method called");
	}
}
