package de.lbbw.moebel;

import de.lbbw.global.Brennbar;

public class Sofa extends Moebel implements Brennbar {
	
	private int brennwert;
	private String type;
	
	public Sofa() {
		super("Sofa");
	}
	
	public Sofa(String typ) {
		super(typ);
		this.brennwert = 10;
	}
	
	public Sofa(String type, int brennwert) {
		super();
		this.brennwert = brennwert;
		this.type = type;
	}

	@Override
	public int brennen() {
		return this.brennwert;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object " + this.getClass() + " wird durch GarbageCollector entfernt.");
	}

	@Override
	public String toString() {
		return "Sofa [brennwert=" + brennwert + ", type=" + type + "]";
	}
	
	
		
}
