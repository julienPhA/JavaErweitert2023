package de.lbbw;

public class Holz {
	static {
		System.out.println("Holz");
	}
	
	private int brennwert;

	public Holz(int brennwert) {
		super();
		this.brennwert = brennwert;
	}

	public int brennen() {
		return brennwert;
	}
	

}
