package de.lbbw;

import java.util.ArrayList;

public class Kunde {

	private String name;
	private String adresse;
	
	private ArrayList<Anlage> anlagen;

	public Kunde(String name, String adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
		anlagen = new ArrayList<>();
	}
	
	void addAnlage(Anlage a) {
		anlagen.add(a);
	}
	
	void printAnlagen() {
		for (Anlage a : anlagen) {
			System.out.println(a.getNr() + " " + a.getWert());
		}
	}
	
}
