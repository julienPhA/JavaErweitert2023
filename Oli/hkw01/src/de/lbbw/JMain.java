package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		
		System.out.println("Fahre Heizkraftwerk hoch!");
		
		Ofen myOfen = new Ofen(130);
		
		Holz eiche = new Holz("Eiche", 30);
		Holz buche = new Holz("Buche", 25);
		Holz fichte = new Holz("Fichte", 12);
		Holz tanne = new Holz("Tanne", 8);
		Dose wurstdose = new Dose("Wurstdose");
		Papier karopapier = new Papier("KaroPapier", 2);
		
		myOfen.beladen(eiche);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(buche);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(karopapier);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(tanne);
		System.out.println("aktuelle Temp: " + myOfen);
		
		//ClassCastException erzwingen und abfangen
		myOfen.beladen(wurstdose);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(eiche);
		System.out.println("aktuelle Temp: " + myOfen);

		myOfen.beladen(eiche);
		System.out.println("aktuelle Temp: " + myOfen);
		
		//eigene Exception -> TemperaturException provozieren
		myOfen.beladen(fichte);
		System.out.println("aktuelle Temp: " + myOfen);
				
		System.out.println("Fahre Heizkraftwerk runter!");
	}

}
