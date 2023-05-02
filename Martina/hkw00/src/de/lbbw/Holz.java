package de.lbbw;

public class Holz  {
	private String typ;
	private int brennwert;
	
	
	
	
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
		return brennwert;
	}

	@Override
	public String toString() {
		return "Holz [typ=" + typ + ", brennwert=" + brennwert + "]";
	}
	
	

}
