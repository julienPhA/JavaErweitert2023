package de.lbbw;

import java.math.BigDecimal;

public class StartApplication {

	public static void main(String[] args) {
		System.out.println("Enter main");
		// abstrakte Klassen können nicht instanziiert werden
		// Konto k0 = new Konto(99,new BigDecimal(0));
		
		Konto k1 = new Sparkonto(100,new BigDecimal(0),50000);
		k1.einzahlen(new BigDecimal(1000));
		System.out.println(k1.getNr()+" "+k1.getSaldo());
		Konto k2 = new Girokonto(101, new BigDecimal(500),10000);
		Kunde kunde = new Kunde("Gosling", "Los Angeles");
		kunde.addKonto(k1);
		kunde.addKonto(k2);
		kunde.printKonten();
		
		System.out.println("Exit main");
		
	}

}
