package de.lbbw.brennelemente;

import de.lbbw.global.Brennbar;

public class Holz implements Brennbar {
	private String typ;
	private int brennwert;

	static {
		System.out.println("Ich bin ein Holz");
	}
	
	public Holz() {
		this.typ = "IrgendeinHolz";
		this.brennwert = 5;
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

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Lösche Object: " + this.getTyp() + "der Klasse: " + this.getClass());
	}	

	
	
}
