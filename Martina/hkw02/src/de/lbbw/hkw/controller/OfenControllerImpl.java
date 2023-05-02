package de.lbbw.hkw.controller;

import de.lbbw.hkw.brennelemente.Holz;
import de.lbbw.hkw.brennelemente.Papier;
import de.lbbw.hkw.moebel.Sofa;
import de.lbbw.hkw.ofen.Ofen;
import de.lbbw.hkw.util.ObjectFactoryImpl;
public class OfenControllerImpl {
	Ofen o1 = new Ofen();
	
	public void verbrennen(){
		
	
	
	
	
	System.out.println(o1);
	
	Holz buche = new Holz ("Buche", 30);
	Holz eiche = new Holz ("Eiche", 40);
	Holz kiefer = new Holz ("Fiefer", 20);
	
	Papier papier = new Papier ("natur",2);
	Sofa sofa = new Sofa ("bequem", 70);
				
	o1.beladen(buche);
	System.out.println(o1);
	
	o1.beladen(eiche);
	System.out.println(o1);
	
    o1.beladen(kiefer);
	System.out.println(o1);
	
	o1.beladen(papier);
	System.out.println(o1);
	
	o1.beladen(sofa);
	System.out.println(o1);
	
	o1.beladen(sofa);
	System.out.println(o1);
	
	o1.beladen(sofa);
	System.out.println(o1);
	
	o1.beladen(sofa);
	System.out.println(o1);
	
	System.gc();
	}
	
	public void verbrennenObject(String classname){
		
		
		ObjectFactoryImpl ofi = new ObjectFactoryImpl();
		Object obj = ofi.create(classname);
		o1.beladen(obj);
		
		}
		
	
}
