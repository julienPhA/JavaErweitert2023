package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		System.out.println("Starte Holzkraftwerk-Application");

		Holz buche = new Holz(40);
		Holz eiche = new Holz(81);
		Holz fichte = new Holz(20);
		
		Papier paper = new Papier(2);
		Dose dose = new Dose("Gold");
		
		System.out.println(buche);
		System.out.println(eiche);
		System.out.println(fichte);
		System.out.println(paper);
		System.out.println(dose);
		
		for(int i = 0; i <2; i++) {
			
		}
		
		Ofen ofen = new Ofen(100, 110);
		
		System.out.println(ofen);
		ofen.beladen(buche);
		System.out.println(ofen);
		ofen.beladen(eiche);
		System.out.println(ofen);
		ofen.beladen(fichte);
		System.out.println(ofen);
		ofen.beladen(paper);
		System.out.println(ofen);
		ofen.beladen(dose);
		System.out.println(ofen);
						
						
		System.out.println("Beende Holzkraftwerk-Application");
	}

}
