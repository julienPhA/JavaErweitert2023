package de.lbbw.hkw.moebel;

import de.lbbw.hkw.global.Brennbar;

public class Sofa extends Moebel implements Brennbar{
	public Sofa(String typ) {
		super(typ);
	}
	@Override
	public int brennen() {
		return 50;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("ein Objekt vom Typ "+this.getClass().getName()+" ist verbrannt");
	}
}
