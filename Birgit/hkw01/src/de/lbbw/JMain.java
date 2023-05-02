package de.lbbw;

public class JMain {
	
	public static void main(String[] args) {
				
		Holz holz1 = new Holz(10);
		Holz holz2 = new Holz(20);
		
		Dose dose = new Dose();

		Ofen ofen = new Ofen(24, 40);		

		ofen.beladen(holz1);
		ofen.beladen(holz2);

		try {
			ofen.beladen(dose);
		} catch (Exception e) {
			System.out.println("Object kann nicht verbrannt werden.");
		}
		
		System.out.println("akt. Temp: " + ofen.getIstTemperatur());

		
		
	}

}
