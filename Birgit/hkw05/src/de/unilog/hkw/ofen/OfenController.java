package de.unilog.hkw.ofen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Properties;

import de.unilog.hkw.brennelemente.Dose;
import de.unilog.hkw.brennelemente.Holz;
import de.unilog.hkw.brennelemente.Papier;
import de.unilog.hkw.global.Brennbar;
import de.unilog.hkw.moebel.Metallschrank;
import de.unilog.hkw.moebel.Sofa;
import de.unilog.hkw.util.ObjectFactory;

import com.mysql.cj.jdbc.MysqlDataSource;


/**
 * Im OfenController 
 * @author User700
 *
 */
public class OfenController {

	private Ofen ofen;
	private ObjectFactory factory;
	private int istTemperatur;
	private int sollTemperatur;
	private int kuehTemperatur;
	

	
	public static MysqlDataSource dataSource = new MysqlDataSource();
	public static Connection connection = null;


	public void readOfenProperties() {
		try (InputStream input = new FileInputStream("ofen.properties")) {
			Properties props  = new Properties();
			props.load(input);
			System.out.println("Properties file gelesen");
			for(Entry<Object,Object> entry : props.entrySet()) {
				String key = (String) entry.getKey();
				int value = Integer.parseInt((String)entry.getValue());
				switch (key) {
				case "istTemperatur":
					istTemperatur = value;
					break;
				case "sollTemperatur":
					sollTemperatur = value;
					break;
				case "kuehlTemperatur":
					kuehTemperatur = value;
					break;
				default:
					// do nothing
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public OfenController() {
		ofen = new Ofen();	
		factory = new ObjectFactory();
		readOfenProperties();
		
	}
	
	public void verbrennen() {
		for(int i=0; i<2;i++) {
			ofen.beladen(new Dose("Blech"));
			ofen.beladen(new Holz("Birke"));
			ofen.beladen(new Metallschrank("Aluminium"));
			ofen.beladen(new Papier("Pappe"));
			ofen.beladen(new Sofa("Cord"));
		}
	}

	public void verbrennenMitObjectFactory() {
		Object object = null;
		object = factory.create("de.unilog.hkw.brennelemente.Dose", "Blech");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.brennelemente.Holz", "Birke");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.Metallschrank", "Aluminium");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.brennelemente.Papier", "Pappe");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.Sofa", "Cord");
		if (object!=null)  ofen.beladen(object);	
		object = factory.create("de.unilog.hkw.moebel.DoesNotExist");
		if (object!=null)  ofen.beladen(object);	
	}
	
	public void verbrenneSortiert() {
		ArrayList<Brennbar> brennbareElemente  = new ArrayList<>();
		//HashMap<String,String> brennelementliste = erzeugeBrennelementliste();
		HashMap<String,String> brennelementliste = erzeugeBrennelementlisteVonDB();
		for(String key : brennelementliste.keySet()) {
			String typeString = brennelementliste.get(key);
			String columns[] = typeString.split(";");
			Object o = factory.create(columns[0],columns[1]);
			if(o==null) {
				System.out.println("Ofencontroller:  Objekt "+o+" konnte nicht erzeugt werden");
			} else {
				if(!(o instanceof Brennbar)) {
					System.out.println("Ofencontroller:  Objekt "+o+" ist nicht brennbar");
				} else {
					brennbareElemente.add((Brennbar)o);
				}
			} 
		}
		Collections.sort(brennbareElemente, (e1,e2)->e1.brennen()-e2.brennen());
		System.out.println("Ofencontroller: Verbrenne sortiert");
		for(Brennbar e : brennbareElemente) {
			ofen.beladen(e);
			schreibeLogeintrag(e);
		}
	}
	
	private HashMap<String,String> erzeugeBrennelementliste() {
		HashMap<String,String> brennelementliste = new HashMap<>();
		File file  = new File("brennelemente.txt");
		System.out.println("Ofencontroller: Lese Brennelementedatei");
		try (BufferedReader reader = new BufferedReader(new FileReader(file,Charset.forName("UTF-8")))) {
			String zeile = "";
			while( (zeile = reader.readLine()) != null) {
				String[] columns = zeile.split(";");
				brennelementliste.put(columns[0],columns[1]+";"+columns[2]);
			}
			System.out.println("Ofencontroller: Brennelementedatei gelesen");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ofencontroller: Brennelementliste erzeugt");
		return brennelementliste;
	}
	
	private HashMap<String,String> erzeugeBrennelementlisteVonDB() {
		HashMap<String,String> brennelementliste = new HashMap<>();

		System.out.println("Ofencontroller: Lese BrennelementeDB");
		connectToDB();
		try (
				Statement stmt  = (Statement) connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT keyname, objname, typname FROM brennelemente");
			)
		{
			// Schleife  über das gesamte ResultSet
			while (rs.next()) {
				// Für jede gelesene Zeile (row) der Tabelle:
				// Gib einen Integer- (1. Spalte) und einen Stringwert (2. Spalte) aus
				String keyname = rs.getString(1);
				String objname = rs.getString(2);
				String typname = rs.getString(3);
			    System.out.println(keyname+","+objname+","+typname);
			    brennelementliste.put(keyname, objname + ";" + typname);
			}
			System.out.println("***");
		} catch(SQLException e) {
			System.out.println("Fehler beim Datenbankzugriff "+e.getMessage());
		} // hier wird close f�r das Statement und das ResultSet aufgerufen
		disconnect();
		System.out.println("Ofencontroller: Brennelementliste erzeugt");
		return brennelementliste;
	}
	
	public static void connectToDB() {
		System.out.println("try to connect to db ...");
		dataSource.setUser("root");
		dataSource.setPassword("root");
	    dataSource.setServerName("localhost");
	    dataSource.setPort(3306);
	    dataSource.setDatabaseName("hotel");
	    try {
			dataSource.setUseSSL(false);
			connection = (Connection) dataSource.getConnection();
			System.out.println("connected to db");
		} catch (SQLException e) {
			System.out.println("Cannot connect to database "+e.getMessage());
		}
	}
	public static void disconnect() {
		if(connection==null) {
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
	
	public void schreibeLogeintrag(Brennbar br) {
		connectToDB();
		insertRow(br);
		disconnect();
		
	}
	
	public static void insertRow(Brennbar br) {
		String insertSQL = "INSERT INTO logtable VALUES (?, ?, ?)";
		try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);)
		{
			preparedStatement.setString(1, "userHugo");
			preparedStatement.setString(2, br.getMaterial());
			Timestamp actDate = new Timestamp(System.currentTimeMillis());
			preparedStatement.setString(3, actDate.toString());
			
			LocalDateTime k;
			// fuehre INSERT aus
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fehler beim INSERT "+e.getMessage());
		}
	}
}
