package de.lbbw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.global.Brennbar;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactoryImpl;

public class OfenController {
	
	private Ofen ofen = new Ofen(100, 110);
	private HashMap<String, String> brennelementeMap = new HashMap<>();
		
	public void verbrennen() {
		Holz buche = new Holz(40);
		Sofa mySofa = new Sofa("Wohnzimmer");
		Papier paper = new Papier(2);
		Dose dose = new Dose("Gold");
		
		System.out.println(buche);
		System.out.println(paper);
		System.out.println(dose);
						
		ofen.beladen(buche);
		ofen.beladen(paper);
		ofen.beladen(dose);
		ofen.beladen(mySofa);			
	}
	
	/**
	 * @author Simon Weiss
	 * @param 
	 * Empty Brennwelement List
	 */
	public void erzeugeBrennelementList() {
		brennelementeMap.put("Buchenholz", "de.lbbw.brennelemente.Holz;Buche;50");
		brennelementeMap.put("Fichtenholz", "de.lbbw.brennelemente.Holz;Fichte;25");
		brennelementeMap.put("Ecksofa", "de.lbbw.moebel.Sofa;Sofa;5");
		brennelementeMap.put("Dose", "de.lbbw.Dose;Dose;0");
	}
	
	public void verbrenneSortiert() {
				
		ArrayList<Brennbar> brennmaterial = new ArrayList<Brennbar>();
		
		String row;
		String[] spalten;
		Object o;
    	String classname;
		String type;
		String brennwert; 
				
		for (String key : brennelementeMap.keySet()) {

	        row = brennelementeMap.get(key);
	        spalten = row.split(";");
	        
	        if (spalten.length == 3) {
	        	classname = spalten[0];
		        type = spalten[1];
		        brennwert = spalten[2];
	        } else {
	        	classname = spalten[0];
		        type = spalten[1];
		        brennwert = "";
	        }
	                
	        System.out.println(classname + " -> " + type + " -> " + brennwert); 
	        
	        if (brennwert == "") {
	        	o = getBrennmaterialObjekt(classname, type);
	        } else {
	        	o = getBrennmaterialObjekt(classname, type, Integer.parseInt(brennwert));
	        }
	        
	        if (o instanceof Brennbar) {
	        	brennmaterial.add((Brennbar)o);
	        } else {
	        	System.out.println(classname + " ist NICHT brennbar!!!");
	        }
	    }
		
		// Teil 2 Sortierung ArrayList
		
		System.out.println("Anzahl der Elemente: " + brennmaterial.size());
		
		Collections.sort(brennmaterial, (o1, o2) -> o1.brennen() - o2.brennen() );
		
		for (Brennbar b : brennmaterial) {
			ofen.beladen(b);
		}		
	}
	
	/**
	 * @author Simon Weiss
	 * @param 
	 * classname bspw. de.lbbw.brennelemente.Holz
	 */
	
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
	

	public Object getBrennmaterialObjekt(String classname, String type, int brennwert) {
		ObjectFactoryImpl factory = new ObjectFactoryImpl();
		Object o = factory.create(classname, type, brennwert);
		return o;
	}
	
	public Object getBrennmaterialObjekt(String classname, String type) {
		ObjectFactoryImpl factory = new ObjectFactoryImpl();
		Object o = factory.create(classname, type);
		return o;
	}
	
}
