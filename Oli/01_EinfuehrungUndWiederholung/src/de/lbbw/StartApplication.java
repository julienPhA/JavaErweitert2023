package de.lbbw;

import java.math.BigDecimal;

public class StartApplication {

	public static void main(String[] args) {
		System.out.println("Enter main");
		
		//abstakte KLassen können nicht instanziiert werden, also kein Objekt angelegt werden
		//Konto k0 = new Konto(100, new BigDecimal(0));
		Konto k1 = new Sparkonto(100, new BigDecimal(0),50000);
		k1.einzahlen(new BigDecimal(1000));
		
		Konto k2 = new Girokonto(101, new BigDecimal(500),10000);

		Kunde kunde = new Kunde("Gosling", "Loas Angeles");
		kunde.addKonto(k1);;
		kunde.addKonto(k2);
		kunde.printKonten();
		
		System.out.println("Exit main");
	}
}