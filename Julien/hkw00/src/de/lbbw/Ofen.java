package de.lbbw;

public class Ofen {
	private int istTemp = 0;
	private int sollTemp;
	private Brennkammer bk;
	
	private class Brennkammer{
		private Ofen o;
				
		public Brennkammer(Ofen o) {
			this.o = o;
		}

		public void verbrennen(Brennbar b) {
			o.setIstTemp(
					o.getIstTemp()
					+ b.getBrennwert()
					);
		}
	}
	
	
	
	public Ofen(int sollTemp) {
		this.sollTemp = sollTemp;
		bk = new Brennkammer(this);
	}


	public void beladen(Object o) {
		try {
			bk.verbrennen((Brennbar) o);
		}
		catch (ClassCastException e) {
			System.out.println(
					o.getClass().getSimpleName()
					+ " kann nicht verbrannt werden!"
					);
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
}