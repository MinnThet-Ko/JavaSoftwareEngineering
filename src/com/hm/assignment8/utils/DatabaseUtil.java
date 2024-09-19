package com.hm.assignment8.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
	private static DatabaseUtil databaseUtil;
	private Properties dbProperties;
	private Connection connection;
	
	private DatabaseUtil() {
		this.dbProperties = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			this.dbProperties.load(loader.getResourceAsStream("database.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseUtil getInstance() {
		if(databaseUtil == null) {
			databaseUtil = new DatabaseUtil();
		}
		return databaseUtil;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(this.dbProperties.getProperty("url"), this.dbProperties.getProperty("username"), this.dbProperties.getProperty("password"));
			return this.connection;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
