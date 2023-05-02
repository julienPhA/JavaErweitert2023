package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		
		System.out.println("Start Ofen");

		Ofen o = new Ofen(0, 50);
		
		System.out.println("Ofen Ist-Temperatur: " + o.getIstTemperatur() + " Soll-Temperatur: " + o.getSollTemperatur());
		
		o.beladen(new Holz("Eiche", 20));
		o.beladen(new Holz("Fichte", 15));
		o.beladen(new Holz("Eiche", 20));
		o.beladen(new Papier("Blatt", 5));
		o.beladen(new Dose("Dose"));
						
		System.out.println("Ende Ofen");
	}
}