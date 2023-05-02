package de.lbbw;

import de.lbbw.brennelemente.Dose;
import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.moebel.Metallschrank;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactory;

public class OfenController {

	public void verbrennen() {
		Ofen ofen = new Ofen();
		for(int i=0; i<1;i++) {
			ofen.beladen(new Dose("Blech"));
			ofen.beladen(new Holz("Birke"));
			ofen.beladen(new Holz("Kirsche"));
			ofen.beladen(new Holz("Eiche"));
			ofen.beladen(new Papier("Pappe"));
			ofen.beladen(new Sofa("Sofa"));
			ofen.beladen(new Metallschrank("Metallschrank"));

		}
	}
	
	public void verbrennen2() {
		
		Ofen ofen = new Ofen();

		ObjectFactory objFact = new ObjectFactory();
		objFact.createString("de.lbbw.brennelemente.Holz", "Eiche");
		ofen.beladen(objFact);
		objFact.createString("de.lbbw.brennelemente.Holz", "Birke");
		ofen.beladen(objFact);
		objFact.createString("de.lbbw.moebel.Sofa", "Stoff");
		ofen.beladen(objFact);
		objFact.createString("de.lbbw.moebel.Metallschrank", "Metall");
		ofen.beladen(objFact);
		
	}
}
