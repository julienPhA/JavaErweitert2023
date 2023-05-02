package de.unilog.hkw;

import de.unilog.hkw.ofen.OfenController;

public class JMain_02 {

	public static void main(String[] args) {
		System.out.println("Enter main");
		// benutze den neuen OfenController um die Simulation zu starten
		OfenController controller = new OfenController();
		controller.verbrennenMitObjectFactory();;
		System.gc();
		System.out.println("Exit main");		
	}

}
