package com.DAO;

import java.util.*;
import java.sql.*;
import com.Connection.*;
import com.Model.*;


public class CountryLanguageDAO 
{
	Connection con=null;
	
	public List<CountryLanguage> loadLingo()
	{
		List<CountryLanguage> loads= new ArrayList<CountryLanguage>();
		try {
			con=ConnectionManager.getConnection();
			
			PreparedStatement pst=con.prepareStatement("SELECT * FROM countrylanguage");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				loads.add(toLanguage(rs));
				rs.close();
				con.close();
			}	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return loads;
		
	}
	
	private CountryLanguage toLanguage(ResultSet rs)
	{
		
		CountryLanguage city=new CountryLanguage();
		try{
			
			city.setCountryCode(rs.getString("countrycode"));
			city.setLanguage(rs.getString("language"));
			
			
		}
		catch (Exception e) {
			
		}
		return city;
		
	}
	
	
}
