package de.lbbw.brennstoffe;

public class Papier extends Brennstoff {
	static {
		System.out.println("Papier verfuegbar.");
		System.out.println("!Var aus Interface Brennbar: " + Papier.TEST);
	}
	
	public Papier() {
		super(10);
	}
}