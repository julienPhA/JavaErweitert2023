package de.lbbw.moebel;

import de.lbbw.global.Brennbar;

public class Sofa extends Moebel implements Brennbar {

	public Sofa(String typ) {
		super(typ);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int brennen() {
		return 40;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Lösche Object: " + this.getClass());
	}	

}
