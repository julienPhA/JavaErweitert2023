package de.lbbw.controller;

import java.util.TreeMap;

import de.lbbw.brennstoffe.Dose;
import de.lbbw.brennstoffe.Holz;
import de.lbbw.brennstoffe.Papier;
import de.lbbw.model.Ofen;
import de.lbbw.moebel.Metallschrank;
import de.lbbw.moebel.Sofa;

public class OfenController {

	public void brennen() {
		Ofen o = new Ofen(300);
		
		TreeMap<String, Object> lieferung = entladeLKW();
		o.beladen(lieferung);
	}

	private TreeMap<String, Object> entladeLKW() {
		TreeMap<String, Object> lieferung = new TreeMap<>();
		
		lieferung.put("Birke", new Holz());
		lieferung.put("Leder", new Sofa("Leder Sofa"));
		lieferung.put("A4", new Papier());
		lieferung.put("Buche", new Holz());
		lieferung.put("Stoff", new Sofa("Couch"));
		lieferung.put("A5", new Papier());
		lieferung.put("Alu", new Metallschrank("Spint"));
		lieferung.put("Fichte", new Holz());
		lieferung.put("Blech", new Dose());
		lieferung.put("Eiche", new Sofa("Eckbank"));
		
		return lieferung;
	}
}
