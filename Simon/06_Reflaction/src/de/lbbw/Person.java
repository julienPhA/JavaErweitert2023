package de.lbbw;

public class Person {

			
	private int nr;
	private String name;
		
	public Person() {
		this.nr = 0;
		this.name = "Mustermann";		
	}
	
	public Person(int nr, String name, String strasse) {
		this.nr = nr;
		this.name = name;
	}

	public int getNr() {
		return nr;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [nr=" + nr + ", name=" + name + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize called for " + this + " -> " + Thread.currentThread().getName());
	}
	

}
