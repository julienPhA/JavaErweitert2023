package de.lbbw;

public class Holz {

	private String typ;
	protected int brennwert;
	
	static {
		System.out.println("Holz eingeworfen");
	}
	
	public Holz(String typ, int brennwert) {
		super();
		this.typ = typ;
		this.brennwert = brennwert;
	}
	
	public int brennen() {
		return brennwert;		
	}
	
}
