package de.lbbw.moebel;

import de.lbbw.global.Brennbar;

public class Sofa extends Moebel implements Brennbar {

	static {
		System.out.println("Sofa eingeworfen");
	}
	
	public Sofa(String typ, int brennwert) {
		this.typ = typ;
		this.brennwert = brennwert;
	}

	@Override
	public int brennen() {
		return brennwert;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Das Sofa ist verbrannt.");
	}	
}
