package de.lbbw.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import de.lbbw.brennstoffe.Brennstoff;
import de.lbbw.model.Brennbar;
import de.lbbw.model.Ofen;
import de.lbbw.moebel.Sofa;

public class OfenController {
	
	public void brennen() {
		Ofen o = new Ofen(300);
		Scanner scn = new Scanner(System.in);
		String eingabe = scn.nextLine();
		
		while (!eingabe.equals("q")){
			Brennbar bb;
			
			try {
				Class<?> cls = Class.forName("de.lbbw." + eingabe);
				Constructor<?> cstr;
				
				if (cls.getSuperclass().equals(Brennstoff.class)) {
					cstr = cls.getConstructor();
					bb = (Brennbar) cstr.newInstance();
				}
				else if (cls.equals(Sofa.class)) {
					cstr = cls.getConstructor(String.class);
					bb = (Brennbar) cstr.newInstance("couch");
				}
				else
					throw new Exception("Material nicht brennbar!");
				
				o.beladen(bb);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			eingabe = scn.nextLine();
			System.gc();
		}
		scn.close();
	}
}
