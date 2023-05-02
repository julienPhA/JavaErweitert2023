package de.lbbw.hkw.controller;

import de.lbbw.hkw.ofen.OfenControllerImpl;

public class JMain {
	
	

	public static void main(String[] args) {
		System.out.println("Enter main");
		// benutze den neuen OfenController um die Simulation zu starten
		OfenControllerImpl controller = new OfenControllerImpl();
		//controller.verbrennenMitObjectFactory();;
		//controller.writeToCSVFile();
		controller.verbrenneSortiert();
		//System.gc();
		System.out.println("Exit main");		
	}

}
