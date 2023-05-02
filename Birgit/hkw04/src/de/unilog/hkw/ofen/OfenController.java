package de.unilog.hkw.ofen;

import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
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
	
	private Ofen ofen;
	ObjectFactory factory;


	public OfenController() {
		ofen = new Ofen();	
		factory = new ObjectFactory();
		
		try (InputStream input = new FileInputStream("config.properties")){
			Properties props = new Properties();
			props.load(input);
			for (Entry<Object, Object> entry : props.entrySet()) {
				System.out.println("Gelesen: Key: " + entry.getKey() + " Value: " + entry.getValue());
				
			}
			ofen.setIstTemperatur(Integer.parseInt(props.getProperty("istTemperatur")));
			ofen.setKuehlTemperatur(Integer.parseInt(props.getProperty("kuehlTemperatur")));
			ofen.setSollTemperatur(Integer.parseInt(props.getProperty("sollTemperatur")));			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
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
		File file =  new File("Brennelemente.txt");
			try (BufferedReader reader  = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
				String zeile = "";
				while ((zeile = reader.readLine()) != null) {
					String[] spalten = zeile.split(";");
					String ident = spalten[0];
					String objName = spalten[1];
					String typName = spalten[2];
					brennelementMap.put(ident, objName + ";" + typName);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		return brennelementMap;
	}
	
	public void verbrenneSortiert() {
		
		HashMap<String, String> brennelementMap = erzeugeBrennelementliste ();
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
