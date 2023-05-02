package de.lbbw;

public class Kunde implements Person {
	private int nr;
	private String name;
	public Kunde() {
		this.nr = 0;
		this.name = "N.A.";
	}
	public Kunde(int nr, String name) {
		this.nr = nr;
		this.name = name;
	}
	public int getNr() {
		return nr;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Kunde [nr=" + nr + ", name=" + name + "]";
	}
    
}
