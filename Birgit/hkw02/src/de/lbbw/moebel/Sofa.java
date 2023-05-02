package de.lbbw.moebel;

import de.lbbw.global.Brennbar;

public class Sofa extends Moebel implements Brennbar{
	static {
		System.out.println("Sofa erzeugt");
	}
	
	public Sofa(String typ) {
		super(typ);
	}
	
	public int brennen() {
		return 33;
	}
	
	protected void finalize()  throws Throwable {
		System.out.println("Sofa vom Typ " + getTyp() + " verbrannt.-------------------------");		
	}

	
}

