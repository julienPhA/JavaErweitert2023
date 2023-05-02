package de.lbbw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import de.lbbw.brennelemente.Dose;
import de.lbbw.brennelemente.Holz;
import de.lbbw.brennelemente.Papier;
import de.lbbw.global.Brennbar;
import de.lbbw.moebel.Sofa;
import de.lbbw.ofen.Ofen;
import de.lbbw.util.ObjectFactory;

public class OfenController {
	private Ofen myOfen = new Ofen(130);
	private int istTemperatur;
	private int sollTemperatur;
	private int kuehlTemperatur;
	HashMap<String, String> hm = new HashMap<>();
	
	public OfenController() {
		super();
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties props  = new Properties();
			props.load(input);
			for(Entry<Object,Object> entry : props.entrySet()) {
				System.out.println("Key: "+entry.getKey()+" value: "+entry.getValue());
			}
			System.out.println("Properties file gelesen");
			this.istTemperatur = Integer.parseInt(props.getProperty("istTemperatur"));
			this.sollTemperatur = Integer.parseInt(props.getProperty("sollTemperatur"));
			this.kuehlTemperatur = Integer.parseInt(props.getProperty("kuehlTemperatur"));
			System.out.println("istTemp: " +istTemperatur + " sollTemp: " + sollTemperatur + " kuehlTemp: " +kuehlTemperatur);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void verbrennen() {	
	
		Holz eiche = new Holz("Eiche", 30);
		Holz buche = new Holz("Buche", 25);
		Holz fichte = new Holz("Fichte", 12);
		Holz tanne = new Holz("Tanne", 8);
		Dose wurstdose = new Dose("Wurstdose");
		Papier klopapier = new Papier("KloPapier", 2);
		Sofa couch = new Sofa("Couch");
		
		myOfen.beladen(couch);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(buche);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(klopapier);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(tanne);
		System.out.println("aktuelle Temp: " + myOfen);
		
		//ClassCastException erzwingen und abfangen
		myOfen.beladen(wurstdose);
		System.out.println("aktuelle Temp: " + myOfen);
		
		myOfen.beladen(eiche);
		System.out.println("aktuelle Temp: " + myOfen);

		myOfen.beladen(eiche);
		System.out.println("aktuelle Temp: " + myOfen);
		
		//eigene Exception -> TemperaturException provozieren
		myOfen.beladen(fichte);
		System.out.println("aktuelle Temp: " + myOfen);

	}
	
	public void verbrennenObjekt(String name) {
		ObjectFactory of = new ObjectFactory();
		myOfen.beladen(of.create(name));
	}
	
	public void verbrennenObjekt(String name, String typ, int bw) {
		ObjectFactory of = new ObjectFactory();
		myOfen.beladen(of.create(name, typ, bw));
	}
	
	public void erzeugeBrennelementliste() {
	
//		hm.put("Buchenholz",new String("de.lbbw.brennelemente.Holz;Buche;25"));
//		hm.put("Eichenholz",new String("de.lbbw.brennelemente.Holz;Eiche;30"));
//		hm.put("Tannenholz",new String("de.lbbw.brennelemente.Holz;Tanne;5"));
//		hm.put("Balsaholz",new String("de.lbbw.brennelemente.Holz;Balsa;8"));
//		hm.put("Zeitung",new String("de.lbbw.brennelemente.Papier;Zeitung;3"));
//		hm.put("Pappe",new String("de.lbbw.brennelemente.Papier;Pappe;5"));
		
		File file  = new File("file.txt");
		
		System.out.println("Versuche, vom file zu lesen...");
		try (BufferedReader reader = new BufferedReader(new FileReader(file,Charset.forName("UTF-8")))) {
			String zeile = "";
			// lese alle Zeilen der Datei
			while( (zeile = reader.readLine()) != null) {
				System.out.println("Gelesen: "+zeile);
				
				//Aufsplitten String
				String[] spalten = zeile.split(";");
				for(String spalte : spalten) {
					System.out.println(spalte);					
				}
				hm.put(spalten[0], spalten[1] +";" +spalten[2] +";"+spalten[3]);
				
			}
			System.out.println("Datei gelesen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		

	
	public void verbrenneSortiert() {
		ArrayList<Brennbar> brennmaterial = new ArrayList<Brennbar>();
		
		// Über HashMap iterieren
		for(String key : hm.keySet()) {
			System.out.println("Key: "+key +" value "+hm.get(key));
			
			//Aufsplitten String
			String s = hm.get(key);
			String[] spalten = s.split(";");
			for(String spalte : spalten) {
				System.out.println(spalte);
			}
			
			//Object bauen
			ObjectFactory oF = new ObjectFactory();
			Object o = oF.create(spalten[0], spalten[1], Integer.parseInt(spalten[2]));
			
			if (o instanceof Brennbar) {
				brennmaterial.add((Brennbar)o);
			} else {
				System.out.println("Material nicht brennbar: " +o.toString() );
			}			
		}
		//Sortieren mit Lambdanotifikation
		// -> o1 - o2 ist Asc, o2 - o1 wäre desc !!!
		Collections.sort(brennmaterial,(o1, o2) -> o1.brennen() - o2.brennen() );
		System.out.println("Material nach Brennwert sortiert");		
		for(Brennbar b : brennmaterial) {
			System.out.println("Name: " + b.getClass().getName() + " Brennwert:" + b.brennen());
			myOfen.beladen(b);
		}		
	}
}
