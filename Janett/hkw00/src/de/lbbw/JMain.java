package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		
		System.out.println("Start Ofen");

		Ofen o = new Ofen(0, 50);
		
		System.out.println("Ofen Ist-Temperatur: " + o.getIstTemperatur() + " Soll-Temperatur: " + o.getSollTemperatur());
		
		System.out.println("Ofen mit Eiche beladen");
		o.beladen(new Holz("Eiche", 20));
		
		System.out.println("Ofen mit Fichte beladen");
		o.beladen(new Holz("Fichte", 15));
		
		System.out.println("Ofen mit Eiche beladen");
		o.beladen(new Holz("Eiche", 20));
						
		System.out.println("Ende Ofen");
	}
}