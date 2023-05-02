package de.lbbw.model;

import java.util.ArrayList;
import java.util.Collections;

import de.lbbw.moebel.Moebel;

public class Ofen {
	private int istTemp = 0;
	private int sollTemp;
	private Brennkammer bk;
	
	private class Brennkammer{
		public void intoBrennkammer(ArrayList<Brennbar> bblst) throws TemperaturException {
			for (Brennbar bb : bblst) {
				verbrennen(bb);
			}
			
			if (Ofen.this.getIstTemp() > Ofen.this.getSollTemp())
				throw new TemperaturException(Ofen.this.getIstTemp());			
		}
		
		private void verbrennen(Brennbar bb){
			Ofen.this.setIstTemp(
					Ofen.this.getIstTemp()
					+ bb.getBrennwert()
					);
			System.out.println(
					Ofen.this.istTemp
					+ " ... " + bb.getClass().getSimpleName());
			
			if (bb instanceof Moebel)
				System.out.println( ((Moebel)bb).getBez() );
		}
	}
	
	
	
	public Ofen(int sollTemp) {
		this.sollTemp = sollTemp;
		bk = new Brennkammer();
	}


	public void beladen(ArrayList<Object> alst) {
		ArrayList<Brennbar> bblst = new ArrayList<>();
		
		for (Object object : alst) {
			try {
				bblst.add( (Brennbar) object );
			}
			catch (ClassCastException e) {
				System.out.println(object.getClass().getSimpleName() + " kann nicht verbrannt werden!");
				
				if (object instanceof Moebel)
					System.out.println( ((Moebel)object).getBez() );
			}
		}
		
		//der groeßte Brennwert wird als erstes verbrannt
		Collections.sort(bblst,
				(b1, b2) -> b2.getBrennwert() - b1.getBrennwert()
				);
		
		try {
			bk.intoBrennkammer(bblst);			
		}
		catch (TemperaturException e) {
			System.out.println(e.getMessage());
			
			while (istTemp > sollTemp)
				kuehlen();
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