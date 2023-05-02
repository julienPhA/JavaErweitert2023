package de.lbbw;

public class Person {
	private int nr;
	private String name;
	public Person(int nr, String name) {
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
		System.out.println("Finalize called for "+this+ " on thread "+Thread.currentThread().getName());
	}
    
}
