package de.lbbw.hkw.controller;

import java.util.Scanner;

public class JMain {
	
	
	
	public static void main(String[] args) {
		System.out.println("Start JMain");
		
		
		
		OfenControllerImpl oc = new OfenControllerImpl();
						
		oc.verbrennen();
		
				
		try (Scanner scanner = new Scanner(System.in)) {
			String classname = "";
			while(true) {
				System.out.print("Enter classname: ");
				classname = scanner.nextLine();
				if(classname.equals("EXIT")) {
					break;
				} else {
					oc.verbrennenObject(classname);
				}
			
			
			}
		}
		System.out.println("Ende JMain");

	}

}
