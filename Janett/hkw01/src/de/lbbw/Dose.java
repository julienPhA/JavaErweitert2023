package de.lbbw;

public class Dose {

	private String typ;

	public Dose(String typ) {
		super();
		this.typ = typ;
	}
	
	static {
		System.out.println("Dose eingeworfen");
	}
	
}
