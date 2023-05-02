package de.lbbw.brennelemente;

import de.lbbw.global.Brennbar;

public class Holz implements Brennbar {

	private String typ;
	protected int brennwert;
	
	/*static {
		System.out.println("Holz eingeworfen");
	}*/
	
	public Holz(String typ, int brennwert) {
		super();
		this.typ = typ;
		this.brennwert = brennwert;
	}
	
	public int brennen() {
		return brennwert;		
	}
	

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Das Holz ist verbrannt.");
	}
	
}
