package com.bz.bankingmanagementsystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	final static ConnectDB instance = new ConnectDB();
	final static String hostName = "localhost:3306"; 
	final static String dbName = "Banking_Management";
	final static String userName = "root";
	final static String password = "Lambop@12345";
	
	private ConnectDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public Connection getConnection() {	
		StringBuilder builder = new StringBuilder();
		builder.append("jdbc:mysql://");
		builder.append(hostName).append("/").append(dbName);
		String url = builder.toString();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
