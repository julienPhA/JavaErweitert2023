package de.lbbw;

public class StartApplication {

	public static void demoUncheckedExceptions() {
		int numbers [] = new int[3];
		System.out.println(numbers[3]);
		Konto k1 = new Konto();
		Girokonto gk1 = new Girokonto();
		
		Konto k2 = (Konto)gk1;
		
		gk1 = (Girokonto)k1;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Start");
		demoUncheckedExceptions();
		System.out.println("Ende");
	}

}
