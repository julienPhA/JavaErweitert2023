package de.lbbw;

public class Papier extends Holz {

	static {
		System.out.println("Ich bin ein Papier");
	}
	
	public Papier(String typ, int brennwert) {
		super(typ, brennwert);		
	}



	
}
