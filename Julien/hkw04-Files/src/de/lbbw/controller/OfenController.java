package de.lbbw.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.TreeMap;

import de.lbbw.brennstoffe.Brennstoff;
import de.lbbw.model.Brennbar;
import de.lbbw.model.Ofen;
import de.lbbw.moebel.Sofa;

public class OfenController {

	public void brennen() {
		Ofen o = new Ofen(300);
		
		TreeMap<String, Brennbar> lieferung = entladeLKW();
		o.beladen(lieferung);
	}

	private TreeMap<String, Brennbar> entladeLKW() {
		TreeMap<String, Brennbar> lieferung = new TreeMap<>();
		
		ArrayList<String> flst = FileController.leseObjekte("objekte.txt");
		
		for (String string : flst) {
			String[] stgArr = string.split(";");
			String constParm;
			
			try {
				constParm = stgArr[2];
			}
			catch (ArrayIndexOutOfBoundsException e) {
				constParm = null;
			}
			
			Brennbar bb = reflectObject(stgArr[1], constParm);
			
			if (bb != null)
				lieferung.put(stgArr[0], bb);
		}
		return lieferung;
	}
	
	
	private Brennbar reflectObject(String obj, String constParm) {
		try {
			Class<?> cls = Class.forName("de.lbbw." + obj);
			Constructor<?> cstr;
			
			if (cls.getSuperclass().equals(Brennstoff.class)) {
				cstr = cls.getConstructor();
				return (Brennbar) cstr.newInstance();
			}
			else if (cls.equals(Sofa.class)) {
				cstr = cls.getConstructor(String.class);
				return (Brennbar) cstr.newInstance(constParm);
			}
			else
				throw new Exception("Material nicht brennbar!");
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(obj + " - " + e.getMessage());
		}
		return null;
	}
}
