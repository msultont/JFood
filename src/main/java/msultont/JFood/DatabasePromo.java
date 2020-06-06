package msultont.JFood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * This is database Promo class. Databases' class is intended as single object only.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 22th, 2020
 */
public class DatabasePromo {
    // Global Variables
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static Connection connection;
    private static PreparedStatement prpStatement = null;
    private static Statement statement = null;
    private static int lastId = 0;

    /**
     * Return all promo objects in the array.
     *
     * @return PROMO_DATABASE
     */
    public static ArrayList<Promo> getPromoDatabase() {

        PROMO_DATABASE.clear();
        connection = DatabaseConnection.connection();
        String sql = "SELECT * FROM public.promo;";

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                PROMO_DATABASE.add(
                    new Promo(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getInt("discount"),
                        rs.getInt("min_price"),
                        rs.getBoolean("active")
                    )
                );
            }
            rs.close();
            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return PROMO_DATABASE;
    }

    /**
     * Return the last ID of Promo class has been put into database
     *
     * @return lastId
     */
    public static int getLastId() {
        for (Promo promo : getPromoDatabase())
            lastId = promo.getId();
        return lastId;
    }

    /**
     * Return the promo object by its id
     *
     * @param id  promo's id
     * @return promo
     * @throws PromoNotFoundException  throws if there is no promo object
     */
    public static Promo getPromoById(int id) throws PromoNotFoundException {
        for (Promo promo : getPromoDatabase()) {
            if (promo.getId() == id) {
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }

    /**
     * Return the promo by its code
     *
     * @param code  promo's code
     * @return promo
     */
    public static Promo getPromoByCode(String code) throws PromoNotFoundException{
        for (Promo promo : getPromoDatabase()) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        throw new PromoNotFoundException(code);
    }

    /**
     * Add new promo object into database.
     *
     * @param promo  new promo object
     * @return true if success
     * @throws PromoCodeAlreadyExistsException  throws if current promo object has been added in the database
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException {

        for (Promo promo1 : getPromoDatabase()) {
            if (promo1.getCode().equals(promo.getCode())) {
                throw new PromoCodeAlreadyExistsException(promo);
            }
        }

        connection = DatabaseConnection.connection();
        String sql = "INSERT INTO public.promo " + 
                     "(id, code, discount, min_price, active) " + 
                     "VALUES " + 
                     "(?,?,?,?,?)";
        
        try {
            prpStatement = connection.prepareStatement(sql);
            prpStatement.setInt(1, promo.getId());
            prpStatement.setString(2, promo.getCode());
            prpStatement.setInt(3, promo.getDiscount());
            prpStatement.setInt(4, promo.getMinPrice());
            prpStatement.setBoolean(5, promo.getActive());
            prpStatement.executeUpdate();
            prpStatement.close();
            connection.commit();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        lastId = promo.getId();
        return true;
    }

    /**
     * Activate promo if promo status is false
     *
     * @param id  promo's id
     * @return true if success, false if no promo's id in database
     */
    public static boolean activatePromo(int id) throws PromoNotFoundException{
        
        connection = DatabaseConnection.connection();
        int sql_result = 0;
        String sql = "UPDATE public.promo set active = true where id = ?";

        try {
           prpStatement = connection.prepareStatement(sql);
           prpStatement.setInt(1, id);
           prpStatement.executeUpdate();
           prpStatement.close();
           connection.commit();
           connection.close(); 
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }

        if (sql_result == 1) 
            return true;
        
        throw new PromoNotFoundException(id);
        
    }

    /**
     * Deactivate promo if promo status is true
     *
     * @param id promo's id
     * @return true if success, false if no promo's id in database
     */
    public static boolean deactivatePromo(int id) throws PromoNotFoundException {
        connection = DatabaseConnection.connection();
        int sql_result = 0;
        String sql = "UPDATE public.promo set active = false where id = ?";

        try {
           prpStatement = connection.prepareStatement(sql);
           prpStatement.setInt(1, id);
           prpStatement.executeUpdate();
           prpStatement.close();
           connection.commit();
           connection.close(); 
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        if (sql_result == 1) 
            return true;
        
        throw new PromoNotFoundException(id);
    }

    /**
     * Remove promo object in database
     *
     * @param id  promo's id
     * @throws PromoNotFoundException  throws if no promo's object in the database
     * @return true if success
     */
    public static boolean removePromo(int id) throws PromoNotFoundException {
        connection = DatabaseConnection.connection();
        int sql_result = 0;
        String sql = "DELETE from public.promo WHERE id = ?";

        try {
            prpStatement = connection.prepareStatement(sql);
            prpStatement.setInt(1, id);
            sql_result = prpStatement.executeUpdate();
            prpStatement.close();
            connection.commit();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        if (sql_result == 1) {
            return true;
        }
        
        throw new PromoNotFoundException(id);
        /*
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
        */
    }


}
