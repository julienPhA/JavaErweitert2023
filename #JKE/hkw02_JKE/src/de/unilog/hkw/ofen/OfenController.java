package de.unilog.hkw.ofen;

import de.unilog.hkw.brennelemente.Dose;
import de.unilog.hkw.brennelemente.Holz;
import de.unilog.hkw.brennelemente.Papier;
import de.unilog.hkw.moebel.Metallschrank;
import de.unilog.hkw.moebel.Sofa;
import de.unilog.hkw.util.ObjectFactory;

/**
 * Im OfenController 
 * @author User700
 *
 */
public class OfenController {
	
	public void verbrennen() {
		Ofen ofen = new Ofen();
		for(int i=0; i<2;i++) {
			ofen.beladen(new Dose("Blech"));
			ofen.beladen(new Holz("Birke"));
			ofen.beladen(new Metallschrank("Aluminium"));
			ofen.beladen(new Papier("Pappe"));
			ofen.beladen(new Sofa("Cord"));
		}
	}

	public void verbrennenMitObjectFactory() {
		Ofen ofen = new Ofen();
		Object object = null;
		ObjectFactory factory = new ObjectFactory();
		object = factory.create("de.unilog.hkw.brennelemente.Dose", "Blech");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.brennelemente.Holz", "Birke");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.Metallschrank", "Birke");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.brennelemente.Papier", "Pappe");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.Sofa", "Cord");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.DoesNotExist");
		if (object!=null)  ofen.beladen(object);	
		
		
	}
}
