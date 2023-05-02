package de.lbbw;

public class Holz {

	private int brennwert;

	static {
		System.out.println("Static block Holz");
	}
	
	public Holz(int brennwert) {
		super();
		this.brennwert = brennwert;
	}
	
	public int brennen() {
		return brennwert;
	}

	@Override
	public String toString() {
		return "Holz [brennwert=" + brennwert + "]";
	}
		
}
