package org.example;

public class Brennkammer {
	private Ofen ofen;
	public void verbrennen(Holz holz) {
		int brennwert = holz.brennen();
		System.out.println("Brennkammer: verbrenne Holz mit Brennwert "+brennwert);
		ofen.erhoeheTemperatur(brennwert);
	}
	public Brennkammer(Ofen ofen) {
		this.ofen = ofen;
	}
}
