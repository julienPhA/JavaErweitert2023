package de.lbbw;

public class Person implements Comparable<Person> {

	private class Adresse {
		private String strasse;
		public Adresse(String strasse) {
			super();
			this.strasse = strasse;
		}		
	}
		
	private int nr;
	private String name;
	private Adresse adresse;	
	
	public Person(int nr, String name, String strasse) {
		this.nr = nr;
		this.name = name;
		
		adresse = new Adresse(strasse);
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

	@Override
	public int compareTo(Person other) {
		return this.nr - other.nr;
	}
	

}
