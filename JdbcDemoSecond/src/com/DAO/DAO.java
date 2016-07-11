package com.DAO;

import java.sql.*;
import java.util.*;
import com.connection.ConnectionManager;
import com.model.City;

public class DAO {
	@SuppressWarnings("static-access")
	public ArrayList<City> getData() {
		ArrayList<City> cityList = new ArrayList<City>();

		try {

			Connection con = new ConnectionManager().getConnection();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM City";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				City city = new City();

				city.setId(rs.getString("id"));
				city.setName(rs.getString("Name"));
				city.setCountrycode(rs.getString("Countrycode"));
				city.setDistrict(rs.getString("District"));
				city.setPopulation(rs.getString("Population"));
				cityList.add(city);

			}
			// System.out.println("in dao");
		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return cityList;

	}
	
	
	

	@SuppressWarnings("static-access")
	public void doUpdate(com.model.City city) throws SQLException

	{
		PreparedStatement pstmt = null;

		try {

			Connection con = new ConnectionManager().getConnection();
			String query = "UPDATE City SET name = ?,countrycode = ?,district = ?,population =? where id= ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountrycode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setString(4, city.getPopulation());
			pstmt.setString(5, city.getId());
			pstmt.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(" Please enter valid records");
		}

	}

	@SuppressWarnings("static-access")
	public void doDelete(com.model.City city) throws SQLException {

		PreparedStatement pstmt = null;
		try {
			Connection con = new ConnectionManager().getConnection();
			pstmt = con.prepareStatement(" DELETE FROM City WHERE Id = ?");
			pstmt.setString(1, city.getId());
			pstmt.executeUpdate();

			con.close();

		} catch (Exception e) {

		}

	}

	@SuppressWarnings({ "static-access", "unused" })
	public int docreate(com.model.City city) throws SQLException

	{

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Connection con = new ConnectionManager().getConnection();
			String sql = "INSERT INTO City (Name,Countrycode,District,Population) values (?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountrycode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setString(4, city.getPopulation());

			pstmt.executeUpdate();
			con.close();

		} catch (Exception e) {

		}
		return 0;
	}

}
