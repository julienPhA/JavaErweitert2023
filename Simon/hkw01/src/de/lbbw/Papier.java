package de.lbbw;

public class Papier extends Holz {

	static {
		System.out.println("Static block Papier");
	}
	
	public Papier(int brennwert) {
		super(brennwert);
	}

	@Override
	public String toString() {
		return "Papier [brennen()=" + brennen() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
