package msultont.JFood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseLocation {

    //Global Variables
    private static ArrayList<Location> LOCATION_DATABASES = new ArrayList<>();
    private static Connection connection;
    private static PreparedStatement prpStatement = null;
    private static Statement statement = null;

    /**
     * 
     */
    public static ArrayList<Location> getLocationDatabases() {
        LOCATION_DATABASES.clear();

        Location location;
        connection = DatabaseConnection.connection();
        String sql = "SELECT * FROM public.location;";

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                location = new Location(rs.getString("city"), rs.getString("province"), rs.getString("description"));
                LOCATION_DATABASES.add(location);
            }
            rs.close();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return LOCATION_DATABASES;

    }

    /**
     * 
     */
    public static Location getLocationByCity(String city) throws LocationNotFoundException{
        
        for (Location location : getLocationDatabases()) {
            if (location.getCity().equals(city))
                return location;
        }
        throw new LocationNotFoundException(city);
    }
    
}