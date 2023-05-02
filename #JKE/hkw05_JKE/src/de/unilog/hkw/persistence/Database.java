package de.unilog.hkw.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap; 

import com.mysql.cj.jdbc.MysqlDataSource;

public class Database {
	public MysqlDataSource  dataSource;
	public Connection conn;
	
	public Database() {
		init();
	}
	
	private void init() {
		dataSource = new MysqlDataSource();
		try {
			dataSource.setUseSSL(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setUser("root");
		dataSource.setPassword("root");
	    dataSource.setServerName("localhost");
	    dataSource.setPort(3306);
	    dataSource.setDatabaseName("hkw");
	}

	public HashMap<String,String> loadElements() {
		HashMap<String,String> result = new HashMap<>();
		if(connect()) {
			try (
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT logicalName,material FROM elements");
				)
			{
				while (rs.next()) {
					result.put(rs.getString(1),rs.getString(2));
				}
			} catch(SQLException e) {
				System.out.println("Fehler beim Datenbankzugriff "+e.getMessage());
			} // hier wird close für das Statement und das ResultSet aufgerufen

			disconnect();
		}
		return result;
	}
	
	public  boolean connect() {
		boolean result = false;
	    try {
			conn = dataSource.getConnection();
			result = true;
			System.out.println("connected to db");
		} catch (SQLException e) {
			System.out.println("Cannot connect to database "+e.getMessage());
		}
		return result;
	}
	public boolean disconnect() {
		boolean result = false;
		try {
			conn.close();
			System.out.println("disconnected from db");
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean logAction(String user, String brennelementName) {
		boolean result = false;
		if(connect()) {
			String insert = "INSERT INTO  actions values (?,?,?)";
			try ( PreparedStatement preparedStatement = conn.prepareStatement(insert);)
			{
				preparedStatement.setString(1,user);
				preparedStatement.setString(2,brennelementName);
				preparedStatement.setObject(3, new java.sql.Timestamp(new Date().getTime()));;
				preparedStatement.execute();
			} catch(SQLException e) {
				System.out.println("Fehler beim Datenbankzugriff "+e.getMessage());
				e.printStackTrace();
			}
			disconnect();
		}
		return result;
	}
}
