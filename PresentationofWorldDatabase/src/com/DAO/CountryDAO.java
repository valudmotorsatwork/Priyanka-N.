package com.DAO;
import java.sql.*;
import java.util.*;
import com.Connection.*;
import com.Model.*;

public class CountryDAO {

	Connection con=null;
	
	public List<Country> loadAllCountries() 
	{
		List<Country> results = new ArrayList<Country>();
		try 
		{
			con=ConnectionManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from Country");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			results.add(resultToCountry(rs));
			rs.close();
			con.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return results;
	}
	
	//setting result to Languages object
		private Country resultToCountry(ResultSet rs) 
		{
			Country cntry = new Country();
			try 
			{
				cntry.setCode(rs.getString("code"));
				cntry.setName(rs.getString("name"));
				cntry.setContinent(rs.getString("continent"));
				cntry.setRegion(rs.getString("region"));
				cntry.setPopulation(rs.getString("population"));
				cntry.setHeadOfState(rs.getString("headofstate"));
				cntry.setCapital(rs.getString("capital"));	
				System.out.println(" "+rs.getString("code"));
			}
			catch (SQLException sqle) 
			{
				sqle.printStackTrace();
			}
			return cntry;
		}

	public ArrayList<Country> listProducts()
	{
		
		ArrayList<Country> countryList=new ArrayList<Country>();
		
		Connection con=null;
		
		try{
			
			con=ConnectionManager.getConnection();
			PreparedStatement pst=con.prepareStatement("SELECT c.Code,c.Name,c.Region,c.Population,c.Capital,c.Continent,c.HeadOfState,ct.ID,ct.Name,ct.District,cl.CountryCode,cl.Language FROM Country c LEFT OUTER JOIN City ct ON c.Code=ct.CountryCode LEFT OUTER JOIN countrylanguage cl ON c.Code=cl.CountryCode");
			System.out.println("yes");
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			countryList.add(toCountry(rs));
			rs.close();
			con.close();

		}
		catch (Exception e) {

		}
		
		return countryList;
		
	}
	
	private Country toCountry(ResultSet rs)
	{
		Country cntry = new Country();
		try 
		{
			cntry.setCode(rs.getString("c.Code"));
			cntry.setName(rs.getString("c.Name"));
			cntry.setRegion(rs.getString("c.Region"));
			cntry.setPopulation(rs.getString("c.Population"));
			cntry.setContinent(rs.getString("c.Continent"));
			cntry.setHeadOfState(rs.getString("c.HeadOfState"));
			cntry.setCapital(rs.getString("c.Capital"));	
			cntry.setCity(new City(rs.getString("ct.ID"),rs.getString("ct.Name"),rs.getString("ct.District")));
			cntry.setLanguage(new CountryLanguage(rs.getString("cl.CountryCode"),rs.getString("cl.language")));
		}
		catch (Exception e) {
				
		
		}
		return cntry;
	}
}
