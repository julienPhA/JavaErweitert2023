package de.lbbw;

import java.math.BigDecimal;

public class StartApp {

	public static void main(String[] args) {
		System.out.println("Enter main");
		
		Konto k1 = new Sparkonto(100, new BigDecimal(0), 5000);
		k1.einzahlen(new BigDecimal(1000));
		System.out.println(k1.getNr() + ": " + k1.getSaldo());
		Konto k2 = new Sparkonto(101, new BigDecimal(500), 2000);
		Sparkonto s1 = new Sparkonto(102, new BigDecimal(333), 1500);
		
		Kunde knd = new Kunde("Gosling", "Los Angeles");
		knd.addKonto(k1);
		knd.addKonto(k2);
		knd.addKonto(s1);
		knd.printKonten();
		
		System.out.println("Exit main");
	}

}