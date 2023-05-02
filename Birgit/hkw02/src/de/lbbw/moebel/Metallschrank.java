package de.lbbw.moebel;

public class Metallschrank extends Moebel{
	static {
		System.out.println("Metallschrank erzeugt");
	}
	
	public Metallschrank(String typ) {
		super(typ);
	}
	
}

