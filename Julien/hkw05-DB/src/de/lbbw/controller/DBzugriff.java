package de.lbbw.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBzugriff {
	private static MysqlDataSource dataSource;
	private static Connection connection = null;
	
	
	public DBzugriff() {
		dataSource = new MysqlDataSource();
		connectToDB();
	}
	
	public ArrayList<String> getLadung() {
		ArrayList<String> arlst = new ArrayList<>();
		int anzElem = 0;
		
		try (
				Statement stmt  = (Statement) connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT material, typ, bez FROM stoffe");
			) {
			// Schleife  über das gesamte ResultSet
			while (rs.next()) {
				// Für jede gelesene Zeile (row) der Tabelle:
				// Gib einen Integer- (1. Spalte) und einen Stringwert (2. Spalte) aus
			    arlst.add( rs.getString(1)+";"+rs.getString(2)+";"+rs.getString(3) );
			    anzElem ++;
			}
			System.out.println("Abfrage fertig. Elemente gefunden: " + anzElem);
		}
		catch(SQLException e) {
			System.out.println("Fehler beim Datenbankzugriff "+e.getMessage());
		} // hier wird close fuer das Statement und das ResultSet aufgerufen
		
		return arlst;
	}
	
	public void schreibeLog(String s) {
		String insertSQL = "INSERT INTO loggs VALUES (current_timestamp, ?)";
		try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);)
		{
			preparedStatement.setString(1, s);
			preparedStatement.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void connectToDB() {
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
}