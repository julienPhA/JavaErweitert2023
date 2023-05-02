package de.lbbw;

public class Dose {

	String type;
	
	public Dose() {
		this.type = "Blechdose";
	}
	
	public Dose(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Dose [type=" + type + "]";
	}
	
	
	
}
