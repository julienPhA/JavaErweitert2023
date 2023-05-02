package de.lbbw.model;

import java.util.TreeMap;

import de.lbbw.moebel.Moebel;

public class Ofen {
	private int istTemp = 0;
	private int sollTemp;
	private Brennkammer bk;
	
	private class Brennkammer{
		private void verbrennen(Brennbar bb) throws TemperaturException{
			Ofen.this.setIstTemp(
					Ofen.this.getIstTemp()
					+ bb.getBrennwert()
					);
			System.out.println(
					Ofen.this.istTemp
					+ " ... " + bb.getClass().getSimpleName());
			
			if (bb instanceof Moebel)
				System.out.println( ((Moebel)bb).getBez() );

			if (Ofen.this.getIstTemp() > Ofen.this.getSollTemp())
				throw new TemperaturException(Ofen.this.getIstTemp());			
		}
	}
	
	
	
	public Ofen(int sollTemp) {
		this.sollTemp = sollTemp;
		bk = new Brennkammer();
	}


	public void beladen(TreeMap<String, Brennbar> obtm) {
		for (String stg : obtm.keySet()) {
			System.out.println("belade " + stg + " ...");
			try {
				bk.verbrennen(obtm.get(stg));
			}
			catch (TemperaturException e) {
				System.out.println(e.getMessage());
					
				while (istTemp > sollTemp)
					kuehlen();
			}			
		}
	}

	public int getSollTemp() {
		return sollTemp;
	}
	public void setSollTemp(int sollTemp) {
		this.sollTemp = sollTemp;
	}

	public int getIstTemp() {
		return istTemp;
	}
	public void setIstTemp(int istTemp) {
		this.istTemp = istTemp;
	}
	
	private void kuehlen() {
		istTemp -= 5;
		System.out.println(istTemp);
		
		try {
			Thread.sleep(200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}