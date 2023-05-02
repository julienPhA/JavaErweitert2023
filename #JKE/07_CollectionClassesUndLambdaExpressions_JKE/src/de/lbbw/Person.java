package de.lbbw;

public class Person implements Comparable<Person>{
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
	/**
	 die "natürliche Ordnung" von Personen 
	 wird durch den Vergleich der Nummern hergestellt
	 */
	@Override
	public int compareTo(Person other) {
		return this.nr - other.nr;
	}
}
