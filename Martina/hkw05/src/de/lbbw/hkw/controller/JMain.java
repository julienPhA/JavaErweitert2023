package de.lbbw.hkw.controller;

import de.lbbw.hkw.ofen.OfenController;

public class JMain {

	public static void main(String[] args) {
		System.out.println("Enter main");
		// benutze den neuen OfenController um die Simulation zu starten
		OfenController controller = new OfenController();
		// controller.verbrennenMitObjectFactory();;
		// controller.writeToCSVFile();

		// System.gc();
		OfenController.connectToDB();

		controller.verbrenneSortiert();
		OfenController.disconnect();

		System.out.println("Exit main");
	}

}
