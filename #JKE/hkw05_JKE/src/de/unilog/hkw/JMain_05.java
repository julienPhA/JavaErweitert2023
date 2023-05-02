package de.unilog.hkw;

import de.unilog.hkw.ofen.OfenController;

public class JMain_05 {

	public static void main(String[] args) {
		System.out.println("Enter main05");
		// benutze den neuen OfenController um die Simulation zu starten
		OfenController controller = new OfenController();
		
		controller.verbrenneSortiert();
		
		System.gc();
		System.out.println("Exit main05");		
	}

}
