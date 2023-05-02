package de.lbbw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.global.Brennbar;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactoryImpl;

public class OfenController {
	
	private Ofen ofen;
	private HashMap<String, String> brennelementeMap = new HashMap<>();
	
	
	public OfenController() {
		try (InputStream input = new FileInputStream("config.properties")) {
				
			Properties props = new Properties();
			props.load(input);
			
			System.out.println("Properties-Datei gelesen");
			
			int sollTemperatur = Integer.parseInt(props.getProperty("sollTemperatur"));
			int kuehlTemperatur = Integer.parseInt(props.getProperty("kuehlTemperatur"));
			int istTemperatur = Integer.parseInt(props.getProperty("istTemperatur"));
			
			this.ofen = new Ofen(sollTemperatur,kuehlTemperatur,istTemperatur);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

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
		
		//#1 file path ermitteln
		
		String file = "";
		
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties props = new Properties();
			props.load(input);
	
			file = props.getProperty("fileDaten");
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//#2 daten lesen
		System.out.println("Versuche von File zu lesen");
		try (BufferedReader reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
			String zeile = "";
			while ((zeile = reader.readLine()) != null) {
				System.out.println(zeile);
				
				String[] spalten;
				spalten = zeile.split(";");
				
				brennelementeMap.put(spalten[0], spalten[1]+";"+spalten[2]+";"+spalten[3]);
				
			}
			System.out.println("File vollstaendig ausgelesen");
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
