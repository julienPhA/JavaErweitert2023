package de.lbbw.brennelemente;

import de.lbbw.global.Brennbar;

public class Papier extends Holz implements Brennbar {

	static {
		System.out.println("Ich bin ein Papier");
	}
	
	public Papier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Papier(String typ, int brennwert) {
		super(typ, brennwert);		
	}	
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Lösche Object: " + this.getTyp() + "der Klasse: " + this.getClass());
	}	

}
