package de.lbbw.model;

public class Person {
	
	// Definition der inner class Adresse
	// Komposition als spezieller Fall der Assoziation
	private class Adresse {
		private String strasse;
		private String plz;
		private String ort;
		public Adresse(String strasse, String plz, String ort) {
			this.strasse = strasse;
			this.plz = plz;
			this.ort = ort;
			// Zugriff auf Attribute der umgebenden Klasse "Person"
			System.out.println("Adresse erzeugt fuer Person "+Person.this.name);
		}	
	}
	
	private int nr;
	private String name;
	private Adresse adresse;
	public Person(int nr, String name, String strasse, String plz, String ort) {
		this.nr = nr;
		this.name = name;
		adresse = new Adresse(strasse, plz, ort);
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
