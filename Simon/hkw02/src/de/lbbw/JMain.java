package de.lbbw;

/*
 * @Autor: 	Simon Weiss
 * @Date:	2023-04
 */

public class JMain {

	public static void main(String[] args) {
		System.out.println("Starte Holzkraftwerk-Application");

		OfenController controller = new OfenController();
		//controller.verbrennen();	
		
		controller.verbrennenObjekt("de.lbbw.brennelemente.Holz", "Buche", 50);
		controller.verbrennenObjekt("de.lbbw.brennelemente.Holz", 20);
		controller.verbrennenObjekt("de.lbbw.brennelemente.Papier");
		controller.verbrennenObjekt("de.lbbw.moebel.Sofa");
		controller.verbrennenObjekt("de.lbbw.moebel.Moebel");
		controller.verbrennenObjekt("de.lbbw.Dose");
		controller.verbrennenObjekt("de.lbbw.moebel.MetallSchrank");
		
		System.gc();
						
		System.out.println("Beende Holzkraftwerk-Application");
	}

}
