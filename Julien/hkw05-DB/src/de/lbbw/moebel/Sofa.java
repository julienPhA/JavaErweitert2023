package de.lbbw.moebel;

import de.lbbw.model.Brennbar;

public class Sofa extends Moebel implements Brennbar{
	static {
		System.out.println("Sofa verfuegbar.");
	}

	public Sofa(String bez) {
		super(bez);
	}

	@Override
	public int getBrennwert() {
		return 70;
	}

	@Override
	public void finalize() throws Throwable {
		System.out.println("Sofa vollstaendig verbrannt!");
	}
}