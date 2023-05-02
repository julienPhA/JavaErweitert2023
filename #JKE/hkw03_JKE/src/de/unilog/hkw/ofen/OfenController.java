package de.unilog.hkw.ofen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import de.unilog.hkw.brennelemente.Dose;
import de.unilog.hkw.brennelemente.Holz;
import de.unilog.hkw.brennelemente.Papier;
import de.unilog.hkw.global.Brennbar;
import de.unilog.hkw.moebel.Metallschrank;
import de.unilog.hkw.moebel.Sofa;
import de.unilog.hkw.util.ObjectFactory;

/**
 * Im OfenController 
 * @author User700
 *
 */
public class OfenController {

	private Ofen ofen;
	ObjectFactory factory;


	public OfenController() {
		ofen = new Ofen();	
		factory = new ObjectFactory();
	}
	
	public void verbrennen() {
		for(int i=0; i<2;i++) {
			ofen.beladen(new Dose("Blech"));
			ofen.beladen(new Holz("Birke"));
			ofen.beladen(new Metallschrank("Aluminium"));
			ofen.beladen(new Papier("Pappe"));
			ofen.beladen(new Sofa("Cord"));
		}
	}

	public void verbrennenMitObjectFactory() {
		Object object = null;
		object = factory.create("de.unilog.hkw.brennelemente.Dose", "Blech");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.brennelemente.Holz", "Birke");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.Metallschrank", "Aluminium");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.brennelemente.Papier", "Pappe");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.Sofa", "Cord");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.DoesNotExist");
		if (object!=null)  ofen.beladen(object);	
	}
	
	public void verbrenneSortiert() {
		ArrayList<Brennbar> brennbareElemente  = new ArrayList<>();
		HashMap<String,String> brennelementliste = erzeugeBrennelementliste();
		for(String key : brennelementliste.keySet()) {
			String typeString = brennelementliste.get(key);
			String columns[] = typeString.split(";");
			Object o = factory.create(columns[0],columns[1]);
			if(o==null) {
				System.out.println("Ofencontroller:  Objekt "+o+" konnte nicht erzeugt werden");
			} else {
				if(!(o instanceof Brennbar)) {
					System.out.println("Ofencontroller:  Objekt "+o+" ist nicht brennbar");
				} else {
					brennbareElemente.add((Brennbar)o);
				}
			} 
		}
		Collections.sort(brennbareElemente, (e1,e2)->e1.brennen()-e2.brennen());
		System.out.println("Ofencontroller: Verbrenne sortiert");
		for(Brennbar e : brennbareElemente) {
			ofen.beladen(e);
		}
	}
	
	private HashMap<String,String> erzeugeBrennelementliste() {
		HashMap<String,String> brennelementliste = new HashMap<>();
		brennelementliste.put("DOB","de.unilog.hkw.brennelemente.Dose;Blech");
		brennelementliste.put("HOB","de.unilog.hkw.brennelemente.Holz;Birke");
		brennelementliste.put("MEA","de.unilog.hkw.moebel.Metallschrank;Aluminium");
		brennelementliste.put("PAP","de.unilog.hkw.brennelemente.Papier;Pappe");
		brennelementliste.put("SOC","de.unilog.hkw.moebel.Sofa;Cord");
		brennelementliste.put("AAA","de.unilog.hkw.moebel.DoesNotExist;XXX");
		System.out.println("Ofencontroller: Brennelementliste erzeugt");
		return brennelementliste;
	}
}
