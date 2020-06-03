package msultont.JFood;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/JFood";
    private static final String USER = "postgres";
    private static final String PASSWORD = "muhammad.sulton.5597";
    private static Connection c;

    public static Connection connection() {
        c = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }

}