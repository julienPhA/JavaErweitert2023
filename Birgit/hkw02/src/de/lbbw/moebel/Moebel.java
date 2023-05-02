package de.lbbw.moebel;

public class Moebel {
	static {
		System.out.println("Moebel erzeugt");
	}
	private String typ;
	
	public Moebel(String typ) {
		this.typ = typ;
	}

	public String getTyp() {
		return typ;
	}
	
	
}

