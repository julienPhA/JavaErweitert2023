package de.lbbw;

public class Holz implements Brennbar {
	protected int brennwert = 50;
	
	static {
		System.out.println("Holz verfuegbar.");
	}

	public int getBrennwert() {
		return brennwert;
	}
}