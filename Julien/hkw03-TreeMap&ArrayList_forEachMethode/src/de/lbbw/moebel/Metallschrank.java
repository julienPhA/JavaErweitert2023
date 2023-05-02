package de.lbbw.moebel;

public class Metallschrank extends Moebel {
	static {
		System.out.println("Metallschrank verfuegbar.");
	}

	public Metallschrank(String bez) {
		super(bez);
	}
}
