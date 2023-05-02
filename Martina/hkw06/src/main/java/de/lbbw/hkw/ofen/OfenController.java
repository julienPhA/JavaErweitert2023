package de.lbbw.hkw.ofen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;



import com.mysql.cj.jdbc.MysqlDataSource;

import de.lbbw.hkw.brennelemente.Dose;
import de.lbbw.hkw.brennelemente.Holz;
import de.lbbw.hkw.brennelemente.Papier;
import de.lbbw.hkw.global.Brennbar;
import de.lbbw.hkw.moebel.Metallschrank;
import de.lbbw.hkw.moebel.Sofa;
import de.lbbw.hkw.util.ObjectFactory;

public class OfenController {
	
	ArrayList<Brennbar> brennMaterialList = new ArrayList<Brennbar>();
	
	

	// ivate static final String = null;
	public static File file = new File("brennelemente.txt");
	public static MysqlDataSource dataSource = new MysqlDataSource();
	public static Connection connection = null;

	public void verbrennen() {
		Ofen ofen = new Ofen();
		for (int i = 0; i < 2; i++) {
			ofen.beladen(new Dose("Blech"));
			ofen.beladen(new Holz("Birke"));
			ofen.beladen(new Metallschrank("Aluminium"));
			ofen.beladen(new Papier("Pappe"));
			ofen.beladen(new Sofa("Cord"));
		}
	}

	public void verbrennenMitObjectFactory() {
		Ofen ofen = new Ofen();
		Object object = null;
		ObjectFactory factory = new ObjectFactory();
		object = factory.create("de.lbbw.hkw.brennelemente.Dose", "Blech");
		if (object != null)
			ofen.beladen(object);
		object = factory.create("de.lbbw.hkw.brennelemente.Holz", "Birke");
		if (object != null)
			ofen.beladen(object);
		object = factory.create("de.lbbw.hkw.moebel.Metallschrank", "Birke");
		if (object != null)
			ofen.beladen(object);
		object = factory.create("de.lbbw.hkw.brennelemente.Papier", "Pappe");
		if (object != null)
			ofen.beladen(object);
		object = factory.create("de.lbbw.hkw.moebel.Sofa", "Cord");
		if (object != null)
			ofen.beladen(object);
		object = factory.create("de.lbbw.hkw.moebel.DoesNotExist");
		if (object != null)
			ofen.beladen(object);

	}

	public HashMap<String, String> erzeugeBrennelementliste() {

		HashMap<String, String> brennelementMap = new HashMap<>();

		// HashMap befüllen mit Daten aus File
		try (BufferedReader reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
			String zeile = "";
			// lese alle Zeilen der Datei
			while ((zeile = reader.readLine()) != null) {
				String[] spalten = zeile.split(";");
				String className = spalten[1];
				String constrName = spalten[2];

				brennelementMap.put(constrName, className + ";" + constrName);

				System.out.println("Gelesen: " + zeile);
			}
			System.out.println("File gelesen");
			System.out.println(brennelementMap);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return brennelementMap;
	}

	public HashMap<String, String> erzeugeBrennelementliste2() {

		HashMap<String, String> brennelementMap = new HashMap<>();

		brennelementMap.put("Cord", "de.lbbw.hkw.moebel.Sofa;Cord");
		brennelementMap.put("Blech", "de.lbbw.hkw.brennelemente.Dose;Blech");
		brennelementMap.put("Birke", "de.lbbw.hkw.brennelemente.Holz;Birke");
		brennelementMap.put("Pappe", "de.lbbw.hkw.brennelemente.Papier;Pappe");
		brennelementMap.put("Metall", "de.lbbw.hkw.moebel.Metallschrank;Metall");
		brennelementMap.put("Pluesch", "de.lbbw.hkw.moebel.Sofa;Pluesch");

		return brennelementMap;
	}

	public HashMap<String, String> erzeugeBrennelementlisteVonDB() {

		HashMap<String, String> brennelementMap = new HashMap<>();

		try (Statement stmt = (Statement) connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT constrname, classname, logname  FROM brennmaterial");) {
			// Schleife über das gesamte ResultSet

			while (rs.next()) {

				brennelementMap.put(rs.getString(1), rs.getString(2) + ";" + rs.getString(1));

				// System.out.println("Gelesen: " + zeile);

				// Für jede gelesene Zeile (row) der Tabelle:
				// Gib einen Stringwert (1. Spalte), einen Stringwert (2. Spalte) und einen
				// Stringwert (3. Spalte) aus
				System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3));
			}
			System.out.println("***");

		} catch (SQLException e) {
			System.out.println("Fehler beim Datenbankzugriff " + e.getMessage());
			// hier wird close f�r das Statement und das ResultSet aufgerufen
		}
		return brennelementMap;
	}

	public void schreibeLogeintrag(Brennbar bennobj) {

		String insertSQL = "INSERT INTO vorgaenge VALUES (?, ?, CURRENT_TIMESTAMP)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);) {
			// erstes ? wird ein String mit Inhalt "Fritz"
			preparedStatement.setString(1, "Fritz");
			// zweites ? wird ein String mit Inhalt "Holz"
			preparedStatement.setObject(2, bennobj.toString());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fehler beim INSERT " + e.getMessage());
		}

		try (Statement stmt = (Statement) connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT constrname, classname, logname  FROM brennmaterial");) {
			// Schleife über das gesamte ResultSet

		} catch (SQLException e) {
			System.out.println("Fehler beim Datenbankzugriff " + e.getMessage());
			// hier wird close f�r das Statement und das ResultSet aufgerufen
		}

	}

	public void verbrenneSortiert() {

		HashMap<String, String> brennelementMap = erzeugeBrennelementlisteVonDB();
		Ofen ofen = new Ofen();
		ObjectFactory objFact = new ObjectFactory();

		
		for (String key : brennelementMap.keySet()) {
			String[] spalten = brennelementMap.get(key).split(";");
			String objectName = spalten[0];
			String typName = spalten[1];
			Object obj = objFact.create(objectName, typName);
			Brennbar brennbar = null;
			try {
				brennbar = (Brennbar) obj;
			} catch (ClassCastException e) {
				System.out.println(obj.toString() + " ist nicht brennbar");
				continue;
			}
			brennMaterialList.add(brennbar);
		}

		// List unsortiert
		System.out.println("unsortiert");
		for (Brennbar brennobj : brennMaterialList) {
			System.out.println(brennobj.toString() + " mit Brennwert " + brennobj.brennen());
		}

		Collections.sort(brennMaterialList, new Comparator<Brennbar>() {
			public int compare(Brennbar o1, Brennbar o2) {
				return o1.brennen() - o2.brennen();
			}
		});

		// List sortiert
		System.out.println("sortiert");
		for (Brennbar brennobj : brennMaterialList) {
			System.out.println(brennobj.toString() + " mit Brennwert " + brennobj.brennen());
		}

		for (Brennbar brennObj : brennMaterialList) {
			ofen.beladen(brennObj);
			schreibeLogeintrag(brennObj);
		}

	}

	public static void writeToCSVFile() {

		/**
		 * erzeugt ein CSV File
		 */

		System.out.println("Versuche in File zu schreiben ...");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, Charset.forName("UTF-8")))) {
			for (int i = 0; i < 3; i++) {
				writer.write("Cord;de.lbbw.hkw.moebel.Sofa;Cord");
				writer.newLine();
				writer.write("Blech;de.lbbw.hkw.brennelemente.Dose;Blech");
				writer.newLine();
				writer.write("Birke;de.lbbw.hkw.brennelemente.Holz;Birke");
				writer.newLine();
				writer.write("Pappe;de.lbbw.hkw.brennelemente.Papier;Pappe");
				writer.newLine();
				writer.write("Metall;de.lbbw.hkw.moebel.Metallschrank;Metall");
				writer.newLine();

			}
			System.out.println("File geschrieben");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Verbindung zur Datenbank
	public static void connectToDB() {
		System.out.println("try to connect to db ...");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("heizkraftwerk");
		try {
			dataSource.setUseSSL(false);
			connection = (Connection) dataSource.getConnection();
			System.out.println("connected to db");
		} catch (SQLException e) {
			System.out.println("Cannot connect to database " + e.getMessage());
		}
	}

	// Verbindung unterbrechen
	public static void disconnect() {
		if (connection == null) {
			System.out.println("Cannot disconnect, connection == null");
		} else {
			try {
				connection.close();
				System.out.println("disconnected from db");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addMaterial(Message m) {
		HashMap<String, String> brennelementMap = erzeugeBrennelementlisteVonDB();
		ObjectFactory objFact = new ObjectFactory();
		
		for (String key : brennelementMap.keySet()) {
			String[] spalten = brennelementMap.get(key).split(";");
			String objectName = spalten[0];
			String typName = spalten[1];
			Object obj = objFact.create(objectName, typName);
			Brennbar brennbar = null;
			try {
				brennbar = (Brennbar) obj;
			} catch (ClassCastException e) {
				System.out.println(obj.toString() + " ist nicht brennbar");
				continue;
			}
			brennMaterialList.add(brennbar);
		}

		
		brennMaterialList.add((Brennbar) m);
		System.out.println("added: "+m);
	}
	
	public ArrayList<Brennbar> getAllMaterial() {
		return brennMaterialList;
	}
}
