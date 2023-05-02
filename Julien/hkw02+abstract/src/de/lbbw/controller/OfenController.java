package de.lbbw.controller;

import de.lbbw.brennstoffe.Dose;
import de.lbbw.brennstoffe.Holz;
import de.lbbw.brennstoffe.Papier;
import de.lbbw.model.Ofen;
import de.lbbw.moebel.Metallschrank;
import de.lbbw.moebel.Sofa;

public class OfenController {
	
	public void brennen() {
		Ofen o = new Ofen(300);
		
		o.beladen(new Dose());
		
		while (o.getIstTemp() < o.getSollTemp()) {			
			try {
				o.beladen(new Holz());
				Thread.sleep(400);
				
				o.beladen(new Papier());
				Thread.sleep(700);

				o.beladen(new Sofa("Couch"));
				Thread.sleep(900);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.gc();
		}
		o.beladen(new Metallschrank("Spint"));
	}
}
