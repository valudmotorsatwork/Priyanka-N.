package world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	// String filename = "world.config";
	// ClassLoader loader = PropertyManager.class.getClassLoader( );
	// InputStream instream = loader.getResourceAsStream( filename );

	public static Connection getConnection() throws SQLException {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/world";
		String user = "sa";
		String password = "sa123";
		// Properties prop=new Properties();
		// InputStream in = new FileInputStream("world.config");
		// prop.load(in);
		// in.close();
		Connection conn = null;

		{
			if (conn == null)
				try {
					// Properties prop=loadPropertiesFile();
					Class.forName(driver);
					System.out.println("driver loaded");
					conn = DriverManager.getConnection(url, user, password);
					System.out.println("Connection Established");
				} catch (Exception e) {
					e.printStackTrace();
				}
			return conn;
		}

	}

}
