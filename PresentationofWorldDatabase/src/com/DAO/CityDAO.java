package com.DAO;

import java.sql.*;
import java.util.*;
import com.Connection.*;
import com.Model.*;

public class CityDAO {
	Connection con = null;

	// load cities

	public List<City> loadCity() {
		List<City> cityList = new ArrayList<City>();
		try {

			con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM City");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				cityList.add(toCity(rs));
				rs.close();
				con.close();
			}

		} catch (Exception e) {

		}

		return cityList;

	}

	private City toCity(ResultSet rs) {

		City city = new City();

		try {

			city.setID(rs.getString("ID"));
			city.setName(rs.getString("Name"));
			city.setCountryCode(rs.getString("CountryCode"));
			city.setDistrict(rs.getString("District"));
			city.setPopulation(rs.getString("Population"));

		} catch (Exception e) {

		}

		return city;
	}

	public int getCount() {
		int i = 0;
		try {
			con = ConnectionManager.getConnection();

			PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) AS TOTAL FROM City");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return i;
	}

	public List<City> loadAllCities(int take, int skip) {

		List<City> loads = new ArrayList<City>();
		try {
			con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM City LIMIT ?,?");
			pst.setInt(1, take);
			pst.setInt(2, skip);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				loads.add(toCity(rs));
				rs.close();
				con.close();
			}

		}

		catch (Exception e) {

		}

		return loads;
	}

	public void saveRecord(City city) throws SQLException {
		try {
			con = ConnectionManager.getConnection();
			String sql = "INSERT INTO city (Name,CountryCode,District,Population) VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, city.getName());
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setString(4, city.getPopulation());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	public void deleteRecord(String value) throws SQLException {
		try {
			con = ConnectionManager.getConnection();
			Statement pstmt = con.createStatement();
			pstmt = con.createStatement();
			pstmt.execute("DELETE FROM City WHERE ID =" + Integer.parseInt(value));
			pstmt.close();
			con.close();
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	public void updateRecord(City city) throws SQLException {
		try {

			con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE CITY SET name = ?, countrycode = ?,district=?, population=? WHERE id = ?");
			ps.setString(1, city.getName());
			ps.setString(2, city.getCountryCode());
			ps.setString(3, city.getDistrict());
			ps.setString(4, city.getPopulation());
			ps.setString(5, city.getID());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	public List<Country> loadCountry() {
		List<Country> countryList = new ArrayList<Country>();

		try {

			con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Country");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				countryList.add(toCountry(rs));
				rs.close();
				con.close();
			}

		} catch (Exception e) {

		}

		return countryList;
	}

	private Country toCountry(ResultSet rs) {

		Country city = new Country();
		try {

			city.setCode(rs.getString("code"));
			city.setName(rs.getString("name"));

		}

		catch (Exception e) {

		}
		return city;
	}
}
