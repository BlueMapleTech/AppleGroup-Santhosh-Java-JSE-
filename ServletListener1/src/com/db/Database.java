package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Connection conn;

	
	 
	public Database(String url, String user_name, String password) {
		try {
			System.out.println("checking database");
			Class.forName("com.mysql.jdbc.Driver");
            // Connection conn;
			this.conn = DriverManager.getConnection(url, user_name, password);
			//return this.conn;
 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	public Connection getConnection() {
		return this.conn;
	}
 
	public ResultSet r(String sql) throws SQLException {
		Statement sta = (Statement) conn.createStatement();
		return ((java.sql.Statement) sta).executeQuery(sql);
	}

}
