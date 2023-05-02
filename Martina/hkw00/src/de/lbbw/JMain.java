package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		System.out.println("Start JMain");
		
		Ofen o1 = new Ofen(50,150);
		System.out.println("" + o1 + "");
		
		Holz buche = new Holz("Buche",10);
		Holz eiche = new Holz("Eiche",15);
		Holz kiefer = new Holz("Fichte",5);
		
		System.out.println(buche);
			
		o1.beladen(buche);
		System.out.println(o1);
		
		System.out.println(eiche);
		
		o1.beladen(eiche);
		System.out.println(o1);
		
        System.out.println(kiefer);
		
		o1.beladen(eiche);
		System.out.println(o1);
		
		
		
		System.out.println("Ende JMain");

	}

}
