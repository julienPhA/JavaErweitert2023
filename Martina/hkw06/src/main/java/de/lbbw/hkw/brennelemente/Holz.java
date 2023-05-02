package de.lbbw.hkw.brennelemente;

import de.lbbw.hkw.global.Brennbar;

public class Holz implements Brennbar{
	
	static {
		System.out.println("Holz erzeugt");
	}
	
	public Holz(String typ) {
	}
	
	public int brennen() {
		return 30;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Ein Objekt vom Typ "+this.getClass().getName()+" ist verbrannt");
	}

	
}
