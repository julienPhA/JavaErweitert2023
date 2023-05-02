package de.lbbw;

/*
 * @Autor: 	Simon Weiss
 * @Date:	2023-04
 */

public class JMain {

	public static void main(String[] args) {
		System.out.println("Starte Holzkraftwerk-Application");

		OfenController controller = new OfenController();
		
		controller.erzeugeBrennelementList();
		//controller.erzeugeBrennelementelisteVonDB();
		controller.verbrenneSortiert();
				
		//System.gc();
						
		System.out.println("Beende Holzkraftwerk-Application");
	}

}
