package com.Connection;

import java.sql.*;

import com.Connection.PropertyManager;

public class ConnectionManager {
	public static Connection getConnection() throws SQLException {

		Connection conn = null;

		{
			if (conn == null)
				try {
					// Properties prop=loadPropertiesFile();
					Class.forName(PropertyManager.getProperty("DB_DRIVER_CLASS"));
					System.out.println("Driver loaded successfully");
					conn = DriverManager.getConnection(PropertyManager.getProperty("DB_URL"),
							PropertyManager.getProperty("DB_USERNAME"), PropertyManager.getProperty("DB_PASSWORD"));
					System.out.println("Connection Established");

				} catch (Exception e) {
					e.printStackTrace();
				}
			return conn;
		}

	}
}
