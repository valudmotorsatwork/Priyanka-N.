package world.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import world.ConnectionManager;
import world.domain.City;


public class CityDao {
                public List<City> findByName(String name) {
                                List<City> results = new ArrayList<City>();
                                if (name == null) return results;
                                try {
                                                PreparedStatement pstmt = ConnectionManager.getConnection()
                                                                .prepareStatement( "SELECT * FROM City WHERE name=?" );
                                                pstmt.setString(1, name);
                                                ResultSet rs = pstmt.executeQuery( );
                                                while ( rs.next() ) results.add( resultToCity(rs) );
                                                rs.close();
                                                
                                                
                                } catch (SQLException sqle) {
                                                throw new RuntimeException( sqle );
                                }
                                return results;
                }
                
                public List<City> loadCities() {
                                List<City> results = new ArrayList<City>();
                                //if (name == null) return results;
                                try {
                                                PreparedStatement pstmt = ConnectionManager.getConnection()
                                                                .prepareStatement( "SELECT * FROM City" );
                                                
                                                ResultSet rs = pstmt.executeQuery( );
                                                while ( rs.next() ) results.add( resultToCity(rs) );
                                                rs.close();
                                                
                                                
                                } catch (SQLException sqle) {
                                                throw new RuntimeException( sqle );
                                }
                                return results;
                }
                private City resultToCity( ResultSet rs ) {
                                City city = new City();
                                try {
                                                city.setName( rs.getString("name") );
                                                city.setDistrict( rs.getString("district") );
                                                city.setPopulation( rs.getInt("population") );
                                                city.setCountrycode( rs.getString("countrycode") );
                                                city.setId( rs.getInt("id") );
                                } catch (SQLException sqle) {
                                                throw new RuntimeException( sqle );
                                }
                                return city;
                }


}
