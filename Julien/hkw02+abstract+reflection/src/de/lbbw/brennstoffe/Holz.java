package de.lbbw.brennstoffe;

public class Holz extends Brennstoff {
	static {
		System.out.println("Holz verfuegbar.");
	}
	
	public Holz() {
		super(50);
	}
}