package de.lbbw;

public class Papier extends Holz{
	static {
		System.out.println("Papier");
	}

	public Papier(int brennwert) {
		super(brennwert);
	}

}
