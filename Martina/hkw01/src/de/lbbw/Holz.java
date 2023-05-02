package de.lbbw;

public class Holz  {
	private String typ;
	private int brennwert;
	
	static {
		System.out.println("Static block of class Holz called");
	}
	
	
	public Holz(String typ, int brennwert) {
		super();
		this.typ = typ;
		this.brennwert = brennwert;
	}
	
	public int brennen() {
		return brennwert;
		
		
	}

	public String getTyp() {
		return typ;
	}

	public int getBrennwert() {
	   switch(typ) {
		case "Fichte":
			brennwert = 20;
			break;
		case "Buche":
			brennwert = 30;
			break;
		case "Eiche":
			brennwert = 40;
			break;
		}
		return brennwert;
	}

	@Override
	public String toString() {
		return "Holz [typ=" + typ + ", brennwert=" + brennwert + "]";
	}
	
	

}
