package org.example;

public class Holz {
	private int brennwert;
	private String typ;
	public Holz(String typ) {
		this.typ = typ;
	}
	public int brennen() {
		int brennwert = 10;
		switch(typ) {
		case "Fichte":
			brennwert = 20;
			break;
		case "Birke":
			brennwert = 30;
			break;
		case "Eiche":
			brennwert = 40;
			break;
		}
		return brennwert;
	}

}
