package de.lbbw.brennelemente;

import de.lbbw.global.Brennbar;

public class Holz implements Brennbar{
	
	static {
		System.out.println("Holz erzeugt");
	}
	
	private int brennwert;
	private String typ;
	public Holz(String typ) {
		this.typ = typ;
	}
	public int brennen() {
		return 30;
	}
	
	protected void finalize()  throws Throwable {
		System.out.println("Holz vom Typ " + typ + " verbrannt-------------------.");
		
	}

}
