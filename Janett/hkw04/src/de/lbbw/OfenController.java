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

import de.lbbw.brennelemente.Dose;
import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.global.Brennbar;
import de.lbbw.moebel.MetallSchrank;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactory;

public class OfenController {
	
	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;
	private Ofen o;
	
	public OfenController() {
		readOfenProperties();
	}
	
	public void readOfenProperties() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties props = new Properties();
			props.load(input);
			istTemperatur = Integer.parseInt(props.getProperty("istTemperatur"));
			sollTemperatur = Integer.parseInt(props.getProperty("sollTemperatur"));
			kuehlTemperatur = Integer.parseInt(props.getProperty("kuehlTemperatur"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
		
		//o = new Ofen(0, 50);
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
	
	public HashMap erzeugeBrennelementliste() {
		
		HashMap<String,String>  brennelementeListe = new HashMap<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader("Brennelemente.txt",Charset.forName("UTF-8")))) {
			String zeile = "";
			// lese alle Zeilen der Datei
			while( (zeile = reader.readLine()) != null) {
				String[] spalten = zeile.split(";");
				brennelementeListe.put(spalten[0], spalten[1]+";"+spalten[2]+";"+spalten[3]);
			}
			System.out.println("Datei gelesen");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*brennelementeListe.put("Eiche", "de.lbbw.brennelemente.Holz;Eiche;50");
		brennelementeListe.put("Schrank", "de.lbbw.moebel.MetallSchrank;Schrank;0");
		brennelementeListe.put("Couch", "de.lbbw.moebel.Sofa;Couch;35");
		brennelementeListe.put("Blatt", "de.lbbw.brennelemente.Papier;Blatt;5");
		brennelementeListe.put("Eiche", "de.lbbw.brennelemente.Holz;Eiche;50");*/
				
		return brennelementeListe;
		
	}
	
	public static void printKey(String s) {
		System.out.println(s);
	}
	
	public void verbrenneSortiert() {
		HashMap<String,String> brennelementeListe = erzeugeBrennelementliste();
			
		ObjectFactory of = new ObjectFactory();
		ArrayList<Brennbar> brennmaterial = new ArrayList<>();
		String v;
		String[] spalten;
		
		for(String typ : brennelementeListe.keySet()) {
			
			v = brennelementeListe.get(typ);
			spalten = v.split(";");
			
			Object a = of.create(spalten[0], typ, Integer.parseInt(spalten[2]) );
			
			// entweder so
			if(a instanceof Brennbar) {
				brennmaterial.add((Brennbar) a);
			}
			
			// oder so
			/*try {
				brennmaterial.add((Brennbar) a);
			} catch (ClassCastException e) {
				System.out.println("Es handelt sich nicht um ein brennbares Element: " + a.getClass());
			}*/
		}
		
		// Beispiel für eine Methodenreferenz
		// die statische Methode printKey wird für jeden Key (String) aus dem KeySet der HashMap aufgerufen
		brennelementeListe.keySet().forEach(OfenController::printKey);
		
				 
		Collections.sort(brennmaterial, (Brennbar o1, Brennbar o2)->o1.brennen() - o2.brennen());
		
		/*
		 * oder in langer Variante:
		 * Collections.sort(brennmaterial,  new Comparator<Brennbar>() {

			@Override
			public int compare(Brennbar o1, Brennbar o2) {
				return o1.brennen() - o2.brennen();
			}
		} ); */
				
		System.out.println("-------------------------------------------------");
		System.out.println("Liste mit Brennmaterial nach Brennwert sortiert : ");
		for(Brennbar b : brennmaterial) {
			System.out.println(b);
		}
		System.out.println("-------------------------------------------------");
		
		o = new Ofen(istTemperatur,sollTemperatur,kuehlTemperatur);
				
		for(Brennbar b : brennmaterial) {
			o.beladen(b);
		}
		
	}
}
