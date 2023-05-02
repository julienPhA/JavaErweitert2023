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
		konten = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void addKonto(Konto konto) {
		konten.add(konto);
	}
	
	public void printKonten() {
		System.out.println("Alle Konten des Kunden " + name);
		for (Konto k : konten) {
			System.out.println(k);
			//System.out.println("Nr.: " + k.getNr() + " Saldo: " + k.getSaldo());
		}
	}
			
}
