package de.lbbw.model;

public interface Brennbar {
	//interface fields sind implizit public static final !
	int TEST = 21;
	
	public int getBrennwert();

	public void finalize() throws Throwable;
}