package de.unilog.hkw;

import de.unilog.hkw.ofen.OfenController;

public class JMain_04 {

	public static void main(String[] args) {
		System.out.println("Enter main");
		// benutze den neuen OfenController um die Simulation zu starten
		OfenController controller = new OfenController();
		
		controller.verbrenneSortiert();
		
		System.gc();
		System.out.println("Exit main");		
	}

}
