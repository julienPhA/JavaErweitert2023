package de.lbbw;

public class Holz {
	private String typ;
	private int brennwert;

	static {
		System.out.println("Ich bin ein Holz");
	}
		
	public Holz(String typ, int brennwert) {
		super();
		this.typ = typ;
		this.brennwert = brennwert;
	}

	public int brennen() {
		return brennwert;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getBrennwert() {
		return brennwert;
	}

	public void setBrennwert(int brennwert) {
		this.brennwert = brennwert;
	}	

	
	
}
