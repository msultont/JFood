package msultont.JFood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This is database Seller class. Databases' class is intended as single object only.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 22th, 2020
 */
public class DatabaseSeller {
    // Global Variables
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static Connection connection;
    private static PreparedStatement prpStatement = null;
    private static Statement statement = null;
    private static int lastId = 0;

    /**
     * Return all Seller object in the array.
     *
     * @return SELLER_DATABASE
     */
    public static ArrayList<Seller> getSellerDatabase() {

        SELLER_DATABASE.clear();

        Location location = null;
        connection = DatabaseConnection.connection();
        String sql_seller = "SELECT * FROM public.seller;";

        try {
            statement = connection.createStatement();
            ResultSet rs_seller = statement.executeQuery(sql_seller);

            while (rs_seller.next()) {
                try {
                    location = DatabaseLocation.getLocationByCity(rs_seller.getString("location_city"));
                    
                } catch (LocationNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                SELLER_DATABASE.add(
                    new Seller(
                        rs_seller.getInt("id"), 
                        rs_seller.getString("name"), 
                        rs_seller.getString("email"), 
                        rs_seller.getString("phone_number"), 
                        location
                    )
                );
            }
            rs_seller.close();
            connection.close();   
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return SELLER_DATABASE;
    }

    /**
     * Return the last ID of Seller class has been put into database
     *
     * @return lastId
     */
    public static int getLastId() {
        for (Seller seller : getSellerDatabase())
            lastId = seller.getId();
        return lastId;
    }

    /**
     * Return the seller by its id.
     *
     * @param id  seller's id
     * @return seller
     * @throws SellerNotFoundException  if no seller's id, then throw this exception
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException {
        for (Seller seller : getSellerDatabase()) {
            if (seller.getId() == id) {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
    }

    /**
     * Add new seller's object into database.
     *
     * @param seller  Seller's object
     * @return true indicating success
     */
    public static boolean addSeller(Seller seller) {

        connection = DatabaseConnection.connection();
        String sql = "INSERT INTO public.seller " + 
                     "(id, name, email, phone_number, location_city) " + 
                     "VALUES " + 
                     "(?,?,?,?,?)";

        try {
            prpStatement = connection.prepareStatement(sql);
            prpStatement.setInt(1, seller.getId());
            prpStatement.setString(2, seller.getName());
            prpStatement.setString(3, seller.getEmail());
            prpStatement.setString(4, seller.getPhoneNumber());
            prpStatement.setString(5, seller.getLocation().getCity());
            prpStatement.executeUpdate();
            prpStatement.close();
            connection.commit();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
            
        lastId = seller.getId();
        return true;
    }

    /**
     * Remove seller's object from database.
     *
     * @param id  seller's id
     * @throws SellerNotFoundException  throw exception if no seller's id
     * @return true if success
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException {

        connection = DatabaseConnection.connection();
        int sql_result = 0;
        String sql = "DELETE from public.seller WHERE id = ?";

        try {
            prpStatement = connection.prepareStatement(sql);
            prpStatement.setInt(1, id);
            sql_result = prpStatement.executeUpdate();
            prpStatement.close();
            connection.commit();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (sql_result == 1) {
            return true;
        }

        throw new SellerNotFoundException(id);
    }
}
