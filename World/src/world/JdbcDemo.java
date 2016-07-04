package world;

import java.sql.*;

public class JdbcDemo 
{

	public static void main(String[] args) throws SQLException 
	{
			try 
			{

				String url = "jdbc:mysql://localhost:3306/World";
				String user = "sa";
				String password = "sa123";
				Connection con;
				ResultSet rs;
				Statement stmt;
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Drivers loaded successfully");
				con = DriverManager.getConnection(url, user, password);
				System.out.println("Connection is established");
				System.out.println("You are using the Database : " + con.getMetaData().getDatabaseProductName());
				stmt = con.createStatement();
				System.out.println("Connection type is " + con.getClass());
				System.out.println("Statement type is " + stmt.getClass());
				String query="SELECT * FROM city ";
				rs=stmt.executeQuery(query);
				while(rs.next())
				{
					String name=rs.getString("name");
					String district=rs.getString("district");
					String country=rs.getString("countrycode");
					int population=rs.getInt("population");
					System.out.printf("%s, %s, %s and population is:  %d \n", name,district,country,population );
 							
				}
			} 
			catch (Exception e) 
			{
				System.out.println(" Failed to get a Connection");
				e.printStackTrace();
			}

	}

}
