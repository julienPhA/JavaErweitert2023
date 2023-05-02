package de.lbbw;

import java.util.ArrayList;



public class Kunde {
	private String name;
	private String adresse;
	private ArrayList<Konto> konten;
	public Kunde(String name, String adresse) {
		super();
		this.name = name;
		this.adresse = adresse;
		konten = new ArrayList<Konto>();
	}
	public void addKonto(Konto k) {
		konten.add(k);
	}
	public void printKonten() {
		System.out.println("Alle Konten des Kunden "+name);
		for(Konto k : konten) {
			System.out.println(k);
			//System.out.println("Nr: "+k.getNr()+ " Saldo "+k.getSaldo());
		}
	}

}
