package de.lbbw.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class FileController {
	public static ArrayList<String> leseObjekte(String filename) {
		ArrayList<String> flst = new ArrayList<>();
		
		try ( BufferedReader rd = new BufferedReader(new FileReader(new File(filename), Charset.forName("UTF-8") ) ) ) {
			String zeile;
			
			while ( (zeile = rd.readLine() ) != null )
				flst.add(zeile);
			
			return flst;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}