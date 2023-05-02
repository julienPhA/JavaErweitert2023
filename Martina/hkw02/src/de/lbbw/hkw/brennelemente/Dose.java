package de.lbbw.hkw.brennelemente;

public class Dose {
	public Dose() {
		typ="Blech";
		
	}

	private String typ;

	public Dose(String typ) {
		super();
		this.typ = typ;
	}

	public String getTyp() {
		return typ;
	}

	@Override
	public String toString() {
		return "Dose [typ=" + typ + "]";
	}
	
	

}
