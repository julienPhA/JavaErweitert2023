package de.lbbw;

import de.lbbw.brennelemente.Dose;
import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.moebel.MetallSchrank;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactory;

public class OfenController {

	private Ofen o;
	
	public void verbrennen() {

		System.out.println("Start Ofen");

		o = new Ofen(0, 50);
		
		System.out.println("Ofen Ist-Temperatur: " + o.getIstTemperatur() + " Soll-Temperatur: " + o.getSollTemperatur());
		
		o.beladen(new Holz("Eiche", 20));
		o.beladen(new Holz("Fichte", 15));
		o.beladen(new Holz("Eiche", 20));
		o.beladen(new Papier("Blatt", 5));
		o.beladen(new Dose("Dose"));
		o.beladen(new MetallSchrank("Metallschrank",0));
		o.beladen(new Sofa("Couch",50));
		
		System.gc();
						
		System.out.println("Ende Ofen");
	}
	
	public void verbrennenMitObjectFactory() {
		
		System.out.println("--- Verbrennen mit der ObjectFactory ---");
		
		o = new Ofen(0, 50);
		ObjectFactory of = new ObjectFactory();
		
		Object h = of.create("de.lbbw.brennelemente.Holz", "Eiche", 50);
		o.beladen(h);
		
		Object s = of.create("de.lbbw.moebel.MetallSchrank", "Schrank", 0);
		o.beladen(s);
		
		Object c = of.create("de.lbbw.moebel.Sofa", "Couch", 35);
		o.beladen(c);
		
		Object p = of.create("de.lbbw.brennelemente.Papier", "Blatt", 5);
		o.beladen(p);
		
		Object a = of.create("de.lbbw.brennelemente.Stoff", "Bunt", 5);
		o.beladen(a);
		
		System.out.println("--- Ende ObjectFactory ---");
	}
}
