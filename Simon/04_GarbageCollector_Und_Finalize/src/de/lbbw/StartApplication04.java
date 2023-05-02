package de.lbbw;

public class StartApplication04 {
	
	public static void createObjects() {
		System.out.println("Enter createObjects");
		Person p1 = new Person(101, "Gossling", "Floesserstr");
		Person p2 = new Person(102, "Ritchie", "Am Hauptbahnhof");
		Person p3 = new Person(103, "Stroustrup", "Stuttgarter str.");
		System.out.println("Exit createObjects");
	}

	public static void main(String[] args) {
				
		System.out.println("Enter main " + Thread.currentThread().getName());
		createObjects();
		System.gc(); // läuft im seperaten Thread, läuft nur wenn VM akzeptiert
		System.out.println("Exit main");
		
	}

}
