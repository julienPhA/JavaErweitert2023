package de.lbbw.moebel;

public abstract class Moebel {
	protected String bez;
	
	static {
		System.out.println("Moebel verfuegbar.");
	}
	
	public Moebel(String bez) {
		this.bez = bez;
	}

	public String getBez() {
		return bez;
	}
}
