package de.lbbw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Map.Entry;
import java.util.Properties;

public class StartApp08 {
	
	public static File file = new File("file.txt");

	/**
	 * @author User709
	 */
	
	public static void writeToCSVFile() {
		System.out.println("Versuche in File zu schreiben ...");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, Charset.forName("UTF-8")))) {
			for (int i = 0; i < 3; i++) {
				writer.write("Spalte1;Spalte2");
				writer.newLine();
			}
			System.out.println("File geschrieben");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void readFromCSVFile() {
		System.out.println("Versuche von File zu lesen");
		try (BufferedReader reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
			String zeile = "";
			while ((zeile = reader.readLine()) != null) {
				System.out.println(zeile);
			}
			System.out.println("File vollstaendig ausgelesen");
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		writeToCSVFile();
		readFromCSVFile();
		
		writeToPropertiesFile();
		readFromPropertiesFile();
	}
	
	/**
	 * Properties
	 */
	
	public static void writeToPropertiesFile() {
		try (OutputStream output = new FileOutputStream("config.properties")) {
			
			Properties props = new Properties();
			props.put("servername", "Saturn");
			props.put("portnr", "8080");
			props.put("username", "ritchie");
			props.store(output, null);
			System.out.println("Properties-Datei geschrieben");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readFromPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			
			Properties props = new Properties();
			props.load(input);
			
			for (Entry <Object,Object> entry : props.entrySet()) {
				System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
			}
						
			System.out.println("Properties-Datei gelesen");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
