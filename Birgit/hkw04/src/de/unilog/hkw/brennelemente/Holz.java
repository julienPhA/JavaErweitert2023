package de.unilog.hkw.brennelemente;

import de.unilog.hkw.global.Brennbar;

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
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Ein Objekt vom Typ "+this.getClass().getName()+" ist verbrannt");
	}

	
}
