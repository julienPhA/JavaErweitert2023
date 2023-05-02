package de.unilog.hkw;

public class Ofen {
	private Brennkammer brennkammer;
	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;
	public Ofen() {
		brennkammer = new Brennkammer(this);
		istTemperatur = 20;
		sollTemperatur = 100;
		kuehlTemperatur = 30;
	}
	public void beladen(Object material) {
		System.out.println("Ofen: lade Brennobjekt");
		try {
			brennkammer.verbrennen((Holz) material);
		} catch (ClassCastException e) {
			System.out.println("Hinweis: das Material "+material+" kannn nicht verbrannt werden");
		} catch (TemperaturException e) {
			System.out.println(e.getMessage());
			System.out.println("Ofen: aktiviere Kuehlung");
			istTemperatur = istTemperatur - kuehlTemperatur;
			System.out.println("Ofen Temperatur: "+istTemperatur);
		}
	}
	public int getIstTemperatur() {
		return istTemperatur;
	}

	public void erhoeheTemperatur(int brennwert) {
		istTemperatur = istTemperatur + brennwert;
		System.out.println("Ofen: Temperatur erhoeht -> istTemperatur= "+istTemperatur);
	}
	public int getSollTemperatur() {
		// TODO Auto-generated method stub
		return sollTemperatur;
	}
}
