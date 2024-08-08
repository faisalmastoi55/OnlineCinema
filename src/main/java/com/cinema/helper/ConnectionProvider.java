package com.cinema.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection con;
	
	public static Connection getConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return con;
	}
}
