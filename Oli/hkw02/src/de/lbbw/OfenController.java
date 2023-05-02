package de.lbbw;

import de.lbbw.brennelemente.Dose;
import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactory;

public class OfenController {
	private Ofen myOfen = new Ofen(130);
	
	
	public OfenController() {
		super();
	}
	
	public void verbrennen() {	
	
		Holz eiche = new Holz("Eiche", 30);
		Holz buche = new Holz("Buche", 25);
		Holz fichte = new Holz("Fichte", 12);
		Holz tanne = new Holz("Tanne", 8);
		Dose wurstdose = new Dose("Wurstdose");
		Papier klopapier = new Papier("KloPapier", 2);
		Sofa couch = new Sofa("Couch");
		
		myOfen.beladen(couch);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(buche);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(klopapier);
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

	}
	
	public void verbrennenObjekt(String name) {
		ObjectFactory of = new ObjectFactory();
		myOfen.beladen(of.create(name));
	}
	
	public void verbrennenObjekt(String name, String typ, int bw) {
		ObjectFactory of = new ObjectFactory();
		myOfen.beladen(of.create(name, typ, bw));
	}
}
