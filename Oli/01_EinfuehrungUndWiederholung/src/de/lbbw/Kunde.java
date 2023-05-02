package de.lbbw;

import java.util.ArrayList;

public class Kunde {

	private String name, adresse;
	private ArrayList<Konto> konten;
	
	public Kunde(String name, String adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
		konten = new ArrayList<Konto>();
//		genau gleich
//		konten = new ArrayList<>();		
	}
	
	public void addKonto(Konto k) {
		konten.add(k);
	}
	
	public void printKonten() {
		System.out.println("Konten des Kunden: " + name);
		for(Konto k : konten) {
			System.out.println(k);
		}
	}
}
