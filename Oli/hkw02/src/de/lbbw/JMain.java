package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		
		System.out.println("Fahre Heizkraftwerk hoch!");
		
		OfenController kachelofen = new OfenController();
		
		kachelofen.verbrennen();
		
		kachelofen.verbrennenObjekt("de.lbbw.brennelemente.Holz");
		kachelofen.verbrennenObjekt("de.lbbw.brennelemente.Papier");
		kachelofen.verbrennenObjekt("de.lbbw.brennelemente.Holz", "Buche", 30);
		kachelofen.verbrennenObjekt("de.lbbw.brennelemente.Dose");
		kachelofen.verbrennenObjekt("de.lbbw.moebel.Moebel");
		kachelofen.verbrennenObjekt("de.lbbw.moebel.MetallSchrank");
		
		System.gc();
				
		System.out.println("Fahre Heizkraftwerk runter!");
	}

}
