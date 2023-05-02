package de.lbbw.controller;

import java.util.ArrayList;

import de.lbbw.brennstoffe.Dose;
import de.lbbw.brennstoffe.Holz;
import de.lbbw.brennstoffe.Papier;
import de.lbbw.model.Ofen;
import de.lbbw.moebel.Metallschrank;
import de.lbbw.moebel.Sofa;

public class OfenController {
	
	public void brennen() {
		Ofen o = new Ofen(300);
		
		ArrayList<Object> lieferung = entladeLKW();
		o.beladen(lieferung);
	}

	private ArrayList<Object> entladeLKW() {
		ArrayList<Object> lieferung = new ArrayList<>();
		
		lieferung.add(new Holz());
		lieferung.add(new Sofa("Leder Sofa"));
		lieferung.add(new Papier());
		lieferung.add(new Holz());
		lieferung.add(new Sofa("Couch"));
		lieferung.add(new Papier());
		lieferung.add(new Metallschrank("Spint"));
		lieferung.add(new Holz());
		lieferung.add(new Dose());
		lieferung.add(new Sofa("Eckbank"));
		
		return lieferung;
	}
}
