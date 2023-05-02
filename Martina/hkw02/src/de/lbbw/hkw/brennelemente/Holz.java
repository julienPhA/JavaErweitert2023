package de.lbbw.hkw.brennelemente;

import de.lbbw.hkw.global.Brennbar;

public class Holz implements Brennbar {
	private String typ;
	private int brennwert;
	
	static {
		System.out.println("Static block of class Holz called");
	}
	
	public Holz() {
		typ="Eiche";
		brennwert=0;
	}
	public Holz(String typ, int brennwert) {
		super();
		this.typ = typ;
		this.brennwert = brennwert;
	}
	
	@Override
	public int brennen() {
		return brennwert;
		
		
	}

	public String getTyp() {
		return typ;
	}

	public int getBrennwert() {
	  return brennwert;
	}

	@Override
	public String toString() {
		return "Holz [typ=" + typ + ", brennwert=" + brennwert + "]";
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize called for " + toString() + "on thread " +Thread.currentThread().getName());
	}


}
