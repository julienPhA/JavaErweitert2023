package de.lbbw;

public class Mitarbeiter implements Person {
	private int nr;
	private String name;
	private int gehalt;
	public int getGehalt() {
		return gehalt;
	}
	public Mitarbeiter() {
		this.nr = 0;
		this.name = "N.A.";
		this.gehalt = 0;
	}
	public Mitarbeiter(int nr, String name) {
		this.nr = nr;
		this.name = name;
		this.gehalt = 0;
	}
	public Mitarbeiter(int nr, String name, int gehalt) {
		this.nr = nr;
		this.name = name;
		this.gehalt = gehalt;
	}
	public int getNr() {
		return nr;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Mitarbeiter [nr=" + nr + ", name=" + name + ", gehalt=" + gehalt + "]";
	}



}
