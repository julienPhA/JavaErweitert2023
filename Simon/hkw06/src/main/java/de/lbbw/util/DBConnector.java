package de.lbbw.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public abstract class DBConnector {

	public static MysqlDataSource dataSource = new MysqlDataSource();
	public static Connection connection = null;
	
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
