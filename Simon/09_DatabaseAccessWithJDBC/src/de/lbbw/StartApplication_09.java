package de.lbbw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * demonstriert den Umgang mit dem JDBC API in Java
 * @author JanKettenmann 
 *
 */ 
public class StartApplication_09 { 
	
	public static MysqlDataSource dataSource = new MysqlDataSource();
	public static Connection connection = null;
	
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
	public static void selectRows() {
		try (
				Statement stmt  = (Statement) connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT nr,name FROM zimmer");
			)
		{
			// Schleife  über das gesamte ResultSet
			while (rs.next()) {
				// Für jede gelesene Zeile (row) der Tabelle:
				// Gib einen Integer- (1. Spalte) und einen Stringwert (2. Spalte) aus
			    System.out.println(rs.getInt(1)+","+rs.getString(2));
			}
			System.out.println("***");
		} catch(SQLException e) {
			System.out.println("Fehler beim Datenbankzugriff "+e.getMessage());
		} // hier wird close f�r das Statement und das ResultSet aufgerufen
	}
	public static void insertRows() {
		String insertSQL = "INSERT INTO zimmer VALUES (?, ?)";
		try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);)
		{
			// erstes ? wird ein int mit Wert 101
			preparedStatement.setInt(1, 101);
			// zweites ? wird ein String mit Inhalt "Ritchie"
			preparedStatement.setString(2, "Ritchie");
			// fuehre INSERT aus
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fehler beim INSERT "+e.getMessage());
		}
	}
	public static void updateRows() {
		String updateSQL = "UPDATE zimmer SET name = ? WHERE nr = ?";
		try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(updateSQL);)
		{
			preparedStatement.setString(1, "Stroustrup");
			preparedStatement.setInt(2, 101);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fehler beim UPDATE "+e.getMessage());
		}
	}
	public static void deleteRows() {
		String deleteSQL = "DELETE FROM zimmer WHERE nr = ?";
		try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(deleteSQL);)
		{
			preparedStatement.setInt(1, 101);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Fehler beim DELETE "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		connectToDB();
		selectRows();
		insertRows();
		selectRows();
		updateRows();
		selectRows();
		deleteRows();
		selectRows();
		disconnect();
	}
}
