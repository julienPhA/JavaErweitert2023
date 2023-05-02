package de.lbbw;

public class JMain {

	public static void main(String[] args) {
		System.out.println("Start JMain");
		
		Ofen o1 = new Ofen();
		System.out.println(o1);
					
		o1.beladen(new Holz("Buche",20));
		System.out.println(o1);
		
		o1.beladen(new Holz("Eiche",30));
		System.out.println(o1);
		
        o1.beladen(new Holz("Kiefer",10));
		System.out.println(o1);
		
		o1.beladen(new Holz("Buche",20));
		System.out.println(o1);
		
		o1.beladen(new Holz("Kiefer",10));
		System.out.println(o1);
		
		o1.beladen(new Holz("Eiche",30));
		System.out.println(o1);
		
		o1.beladen(new Holz("Eiche",30));
		System.out.println(o1);
		
		o1.beladen(new Papier("natur",2));
		System.out.println(o1);
		
		o1.beladen(new Dose("Blech"));
		System.out.println(o1);
		
			
			
		System.out.println("Ende JMain");

	}

}
