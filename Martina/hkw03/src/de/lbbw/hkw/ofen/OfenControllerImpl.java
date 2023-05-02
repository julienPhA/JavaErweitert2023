package de.lbbw.hkw.ofen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import de.lbbw.hkw.brennelemente.Dose;
import de.lbbw.hkw.brennelemente.Holz;
import de.lbbw.hkw.brennelemente.Papier;
import de.lbbw.hkw.global.Brennbar;
import de.lbbw.hkw.moebel.Metallschrank;
import de.lbbw.hkw.moebel.Sofa;
import de.lbbw.hkw.util.ObjectFactoryImpl;
public class OfenControllerImpl {
	
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
		ObjectFactoryImpl factory = new ObjectFactoryImpl();
		object = factory.create("de.lbbw.hkw.brennelemente.Dose", "Blech");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.lbbw.hkw.brennelemente.Holz", "Birke");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.lbbw.hkw.moebel.Metallschrank", "Birke");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.lbbw.hkw.brennelemente.Papier", "Pappe");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.lbbw.hkw.moebel.Sofa", "Cord");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.lbbw.hkw.moebel.DoesNotExist");
		if (object!=null)  ofen.beladen(object);	
				
	}

		
	
	public HashMap<String, String> erzeugeBrennelementliste () {
		
		HashMap<String, String> brennelementMap = new HashMap<>();
		brennelementMap.put("Cord", "de.lbbw.hkw.moebel.Sofa;Cord");
		brennelementMap.put("Blech", "de.lbbw.hkw.brennelemente.Dose;Blech");
		brennelementMap.put("Birke", "de.lbbw.hkw.brennelemente.Holz;Birke");
		brennelementMap.put("Pappe", "de.lbbw.hkw.brennelemente.Papier;Pappe");
		brennelementMap.put("Metall", "de.lbbw.hkw.moebel.Metallschrank;Metall");
		brennelementMap.put("Pluesch", "de.lbbw.hkw.moebel.Sofa;Pluesch");

		
		return brennelementMap;
	}
	
	public void verbrenneSortiert() {
		
		HashMap<String, String> brennelementMap = erzeugeBrennelementliste ();
		Ofen ofen = new Ofen();
		ObjectFactoryImpl objFact = new ObjectFactoryImpl();

		ArrayList<Brennbar> brennMaterialList = new ArrayList<Brennbar>();
		
		for (String key : brennelementMap.keySet()) {
			String[] spalten = brennelementMap.get(key).split(";");
			String objectName = spalten[0];
			String typName = spalten[1];
			Object obj = objFact.create(objectName, typName);
			Brennbar brennbar = null;
			try {
				brennbar = (Brennbar) obj;
			} catch (ClassCastException e) {
				System.out.println(obj.toString() + " ist nicht brennbar");
				continue;
			}
			brennMaterialList.add(brennbar);
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
