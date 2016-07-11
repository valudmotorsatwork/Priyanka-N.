package com.Main;

import java.sql.SQLException;

import com.Connection.ConnectionManager;

public class Application {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		ConnectionManager con = new ConnectionManager();
		try {
			con.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
