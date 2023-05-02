package de.lbbw;

import java.util.ArrayList;

public class Kunde {
	private String name; 
	private String adresse;
	private ArrayList<Konto> konten;
	
	
	public Kunde(String name, String adresse) {
		this.name = name;
		this.adresse = adresse;
		konten = new ArrayList<>();
	}
	
	
	public void addKonto(Konto k) {
		konten.add(k);
	}
	public void printKonten() {
		for (Konto k : konten) {
			System.out.println(k);
		}
	}
}