package org.example;

public class Ofen {
	private Brennkammer bk;
	private int istTemperatur;
	public Ofen() {
		bk = new Brennkammer(this);
		istTemperatur = 20;
	}
	public void beladen(Object material) {
		System.out.println("Ofen: lade Brennobjekt");
		bk.verbrennen((Holz) material);
	}
	public int getIstTemperatur() {
		return istTemperatur;
	}
	public void erhoeheTemperatur(int brennwert) {
		istTemperatur = istTemperatur + brennwert;
		System.out.println("Ofen: istTemperatur= "+istTemperatur);

	}
}
