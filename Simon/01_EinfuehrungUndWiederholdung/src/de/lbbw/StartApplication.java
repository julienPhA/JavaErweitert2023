package de.lbbw;

import java.math.BigDecimal;

public class StartApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter main");
		
		Konto k1 = new Sparkonto(100, new BigDecimal(100), 50000);
		
		k1.einzahlen(new BigDecimal(1000));
		
		System.out.println("Konto-Nr.: " + k1.getNr() + " Saldo: " + k1.getSaldo());
		
		Konto k2 = new Girokonto(101, new BigDecimal(500), 10000);
		
		Kunde kunde = new Kunde("Gosling", "Los Angeles");
		
		kunde.addKonto(k1);
		kunde.addKonto(k2);
		
		kunde.printKonten();
		
		// abstrakte Klassen können nicht instanziiert werden!
		//Konto k0 = new Konto(99,new BigDecimal(500));
		
		System.out.println("Exit main");
	}
	
}
