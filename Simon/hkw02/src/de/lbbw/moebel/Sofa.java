package de.lbbw.moebel;

import de.lbbw.global.Brennbar;

public class Sofa extends Moebel implements Brennbar {
	
	public Sofa() {
		super("Sofa");
	}
	
	public Sofa(String typ) {
		super(typ);
	}

	@Override
	public int brennen() {
		return 10;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object " + this.getClass() + " wird durch GarbageCollector entfernt.");
	}
		
}
