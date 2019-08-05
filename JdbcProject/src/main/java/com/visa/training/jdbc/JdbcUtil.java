package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

	public static Connection getConnection() {
		Connection c = null;
		try {
			//LOAD the driver - optional for jdk 1.8
			Class.forName("com.mysql.jdbc.Driver");
			//Establish connection
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/visa", "visa", "secret");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
