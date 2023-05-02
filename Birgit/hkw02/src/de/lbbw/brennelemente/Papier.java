package de.lbbw.brennelemente;

public class Papier extends Holz {

	static {
		System.out.println("Papier erzeugt");
	}
	
	public Papier(String typ) {
		super(typ);
	}

}
