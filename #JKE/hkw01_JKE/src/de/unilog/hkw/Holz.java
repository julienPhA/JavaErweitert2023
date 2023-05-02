package de.unilog.hkw;

public class Holz {
	
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

}
