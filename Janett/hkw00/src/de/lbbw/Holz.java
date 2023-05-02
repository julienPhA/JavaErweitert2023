package de.lbbw;

public class Holz {

	private String typ;
	protected int brennwert;
	
	public Holz(String typ, int brennwert) {
		super();
		this.typ = typ;
		this.brennwert = brennwert;
	}
	
	public int brennen() {
		return brennwert;		
	}
	
}
