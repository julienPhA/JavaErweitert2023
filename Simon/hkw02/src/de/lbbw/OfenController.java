package de.lbbw;

import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactoryImpl;

public class OfenController {
	
	private Ofen ofen = new Ofen(100, 110);

	public void verbrennen() {

		Holz buche = new Holz(40);
		Holz eiche = new Holz(81);
		Holz fichte = new Holz(20);

		Sofa mySofa = new Sofa("Wohnzimmer");
		Papier paper = new Papier(2);
		Dose dose = new Dose("Gold");
		
		System.out.println(buche);
		System.out.println(eiche);
		System.out.println(fichte);
		System.out.println(paper);
		System.out.println(dose);
						
		ofen.beladen(buche);
		ofen.beladen(eiche);
		ofen.beladen(fichte);
		ofen.beladen(paper);
		ofen.beladen(dose);
		ofen.beladen(mySofa);
				
	}
	
	public void verbrennenObjekt(String classname) {
		ObjectFactoryImpl factory = new ObjectFactoryImpl();
		Object o = factory.create(classname);
		
		if (o != null) {
			ofen.beladen(o);
		}
	}
	
	public void verbrennenObjekt(String classname, int brennwert) {
		ObjectFactoryImpl factory = new ObjectFactoryImpl();
		Object o = factory.create(classname, brennwert);
		
		if (o != null) {
			ofen.beladen(o);
		}
	}
	
	public void verbrennenObjekt(String classname, String type, int brennwert) {
		ObjectFactoryImpl factory = new ObjectFactoryImpl();
		Object o = factory.create(classname, type, brennwert);
		
		if (o != null) {
			ofen.beladen(o);
		}
	}
	
	
	
}
