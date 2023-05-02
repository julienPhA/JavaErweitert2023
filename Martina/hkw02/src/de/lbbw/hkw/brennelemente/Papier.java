package de.lbbw.hkw.brennelemente;

public class Papier extends Holz {
	
	
	static {
		System.out.println("Static block of class Papier called");
	}

	public Papier(String typ, int brennwert) {
		super(typ, brennwert);
		
	}
	
	

}
