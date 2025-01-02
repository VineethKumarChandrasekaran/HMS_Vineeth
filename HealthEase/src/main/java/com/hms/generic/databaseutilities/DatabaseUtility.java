package com.hms.generic.databaseutilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	public static Connection connection;

	public void getDBConnection(String url, String username, String password) throws SQLException {
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {

		}
	}

	public void closeDBConnection() {
		try {
			connection.close();
		} catch (Exception e) {

		}
	}

	public ResultSet executeSelectQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeQuery(query);
	}

	public int executeNonSelectQuery(String query) throws SQLException {
		Statement statement = connection.createStatement();
		return statement.executeUpdate(query);
	}
}
