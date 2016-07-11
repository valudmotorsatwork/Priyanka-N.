package com.DAO;


import java.sql.*;
import com.Connection.*;
import com.Model.*;
public class LoginDAO

{

	static Connection con=null;
	static ResultSet rs=null;  
	public static boolean validateLogin(Login bean) 
	{
		Statement stmt = null;
		boolean valid=false;
		String username = bean.getEmail();    
		String password = bean.getPassword();
		String searchQuery ="select * from Login where Email='"+ username + "' AND password='"+ password + "'";     
		try 
		{
			con=ConnectionManager.getConnection();
			stmt=con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			if (!more) 
			{
				valid=false;
			} 
			else if (more) 
			{	
				valid=true;
			}
		} 
		catch (Exception ex) 
		{
			System.out.println("Log In Failed. " + ex);
		}
		return valid;
	}
	
	

	
}
