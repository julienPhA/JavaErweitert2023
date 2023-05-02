package de.lbbw;

public class Dose {
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
