package de.lbbw;

public class Holz {
	
	private String typ;
	private int brennwert;

	public Holz(int brennwert) {
		super();
		this.brennwert = brennwert;
	}

	public int brennen() {
		return brennwert;
	}
	

}
