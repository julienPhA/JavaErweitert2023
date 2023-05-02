package de.lbbw.brennelemente;

import de.lbbw.global.Brennbar;

public class Holz implements Brennbar {

	private int brennwert;
	private String type;

	static {
		System.out.println("Static block Holz");
	}
	
	public Holz() {
		this.brennwert = 5;
		this.type = "Standardholz";
	}
	
	public Holz(int brennwert) {
		super();
		this.brennwert = brennwert;
		this.type = "Standardholz";
	}
		
	public Holz(String type, int brennwert) {
		super();
		this.brennwert = brennwert;
		this.type = type;
	}
	
	public int brennen() {
		return brennwert;
	}

	@Override
	public String toString() {
		return "Holz [type=" + type + " - brennwert=" + brennwert + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object "+toString()+" <" + this.getClass() + "> wird durch GarbageCollector entfernt.");
	}
		
}
