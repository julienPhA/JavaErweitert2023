package de.lbbw;

public class Papier extends Holz {
	static {
		System.out.println("Papier verfuegbar.");
	}
	
	public Papier() {
		brennwert = 10;
	}
}