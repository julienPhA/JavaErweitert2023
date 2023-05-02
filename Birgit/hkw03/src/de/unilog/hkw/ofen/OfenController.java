package de.unilog.hkw.ofen;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import de.unilog.hkw.brennelemente.Dose;
import de.unilog.hkw.brennelemente.Holz;
import de.unilog.hkw.brennelemente.Papier;
import de.unilog.hkw.moebel.Metallschrank;
import de.unilog.hkw.moebel.Sofa;
import de.unilog.hkw.util.ObjectFactory;
import de.unilog.hkw.global.Brennbar;


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

		
	
	public HashMap<String, String> erzeugeBrennelementliste () {
		
		HashMap<String, String> brennelementMap = new HashMap<>();
		brennelementMap.put("Cord", "de.unilog.hkw.moebel.Sofa;Cord");
		brennelementMap.put("Blech", "de.unilog.hkw.brennelemente.Dose;Blech");
		brennelementMap.put("Birke", "de.unilog.hkw.brennelemente.Holz;Birke");
		brennelementMap.put("Pappe", "de.unilog.hkw.brennelemente.Papier;Pappe");
		brennelementMap.put("Metall", "de.unilog.hkw.moebel.Metallschrank;Metall");
		brennelementMap.put("Pluesch", "de.unilog.hkw.moebel.Sofa;Pluesch");

		
		return brennelementMap;
	}
	
	public void verbrenneSortiert() {
		
		HashMap<String, String> brennelementMap = erzeugeBrennelementliste ();
		Ofen ofen = new Ofen();
		ObjectFactory objFact = new ObjectFactory();

		ArrayList<Brennbar> brennMaterialList = new ArrayList<Brennbar>();
		
		for (String key : brennelementMap.keySet()) {
			String[] spalten = brennelementMap.get(key).split(";");
			String objectName = spalten[0];
			String typName = spalten[1];
			Object obj = objFact.create(objectName, typName);
			Brennbar brennbar = null;
			try {
				brennbar = (Brennbar) obj;
				brennMaterialList.add(brennbar);
			} catch (ClassCastException e) {
				System.out.println(obj.toString() + " ist nicht brennbar");
			}
		}
		
		// List unsortiert
		System.out.println("unsortiert");
		for (Brennbar brennobj : brennMaterialList) {
			System.err.println(brennobj.toString() + " mit Brennwert " + brennobj.brennen());
		}
				
		Collections.sort(brennMaterialList, new Comparator<Brennbar>() {
			public int compare(Brennbar o1, Brennbar o2) {
			return o1.brennen() - o2.brennen();
			}
		});
		
		// List sortiert
		System.out.println("sortiert");
		for (Brennbar brennobj : brennMaterialList) {
			System.err.println(brennobj.toString() + " mit Brennwert " + brennobj.brennen());
		}
		
		for (Brennbar brennObj : brennMaterialList) {
			ofen.beladen(brennObj);
			
		}
		
	}
}
