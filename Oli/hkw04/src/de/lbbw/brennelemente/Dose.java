package de.lbbw.brennelemente;

public class Dose {
	private String typ;
	
	static {
		System.out.println("Ich bin eine Dose");
	}
	
	
	
	public Dose() {
		super();
		this.typ = "Blechdose";
	}



	public Dose(String typ) {
		super();
		this.typ = typ;
	}
	
	
}
