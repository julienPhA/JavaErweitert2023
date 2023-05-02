package de.lbbw.moebel;

public abstract class Moebel {

	private String typ;

	public Moebel() {
		this.typ = "undefined";
	}
	
	public String getTyp() {
		return typ;
	}

	public Moebel(String typ) {
		super();
		this.typ = typ;
	}
		
}
