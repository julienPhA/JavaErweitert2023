package de.lbbw.hkw.ofen;

import de.lbbw.hkw.global.Brennbar;

public class Ofen {

	// Komposition mit Inner Class
	private class Brennkammer {
		public void verbrennen(Brennbar material) {
			int brennwert = material.brennen();
			System.out.println("Brennkammer: verbrenne " + material + " mit Brennwert " + brennwert);
			try {
				// Zugriff auf Methode der "Outer Class"
				Ofen.this.erhoeheTemperatur(brennwert);
			} catch (TemperaturException e) {
				System.out.println(e.getMessage());
				Ofen.this.kuehlen();
			}

		}
	}

	private Brennkammer bk;
	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;

	public Ofen() {
		// Übergabe der Referenz auf den Ofen nicht mehr nötig,
		// denn Brennkammer ist jetzt inner class
		bk = new Brennkammer();
		istTemperatur = 20;
		sollTemperatur = 100;
		kuehlTemperatur = 55;
	}

	public void beladen(Object material) {
		System.out.println("Ofen: lade Brennobjekt");
		try {
			bk.verbrennen((Brennbar) material);
		} catch (ClassCastException e) {
			System.out.println(
					"Hinweis: das Material " + material.getClass().getName() + " kannn nicht verbrannt werden");
		}
	}

	public int getIstTemperatur() {
		return istTemperatur;
	}

	public void erhoeheTemperatur(int brennwert) throws TemperaturException {
		istTemperatur = istTemperatur + brennwert;
		System.out.println("Ofen: Temperatur erhoeht -> istTemperatur= " + istTemperatur);
		if (getIstTemperatur() > getSollTemperatur()) {
			throw new TemperaturException(getIstTemperatur(), "Ofentemperatur zu hoch ");
		}

	}

	public int getSollTemperatur() {
		return sollTemperatur;
	}

	public void kuehlen() {
		System.out.println("Ofen: aktiviere Kuehlung");
		istTemperatur = istTemperatur - kuehlTemperatur;
		System.out.println("Ofen Temperatur: " + istTemperatur);
	}

	public void setIstTemperatur(int istTemperatur) {
		this.istTemperatur = istTemperatur;
	}

	public void setSollTemperatur(int sollTemperatur) {
		this.sollTemperatur = sollTemperatur;
	}

	public void setKuehlTemperatur(int kuehlTemperatur) {
		this.kuehlTemperatur = kuehlTemperatur;
	}
}
