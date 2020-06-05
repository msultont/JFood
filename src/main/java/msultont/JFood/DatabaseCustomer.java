package msultont.JFood;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * This customer database to save all customer information
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class DatabaseCustomer {

    // Global Variables
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
    private static Connection connection;
    private static PreparedStatement prpStatement = null;
    private static Statement statement = null;
    private static int lastId = 0;

    /**
     * Return all customer object
     * @return CUSTOMER_DATABASE
     */
    public static ArrayList<Customer> getCustomerDatabase() {
        CUSTOMER_DATABASE.clear();
        connection = DatabaseConnection.connection();
        String sql = "Select * FROM public.customer;";
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                CUSTOMER_DATABASE.add(new Customer(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getString("email"), 
                    rs.getString("password"), 
                    rs.getTimestamp("join_date")));
            }
            rs.close();
            connection.close();   
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return CUSTOMER_DATABASE;
    }

    /**
     * Return the last id of food's object added into the database
     * @return lastId
     */
    public static int getLastId() {
        for (Customer customer : getCustomerDatabase()) {
            lastId = customer.getId();
        }
        return lastId;
    }

    /**
     * Return customer object by its id
     * @param id  customer's id
     * @return customer
     * @throws CustomerNotFoundException  throws if no customer's object
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException {
        for (Customer customer : getCustomerDatabase()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * Add new customer object into database
     *
     * @param customer  customer's object
     * @return true if success
     * @throws EmailAlreadyExistsException  throws if current customer's object has already email registered in the
     * database.
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException {
        Timestamp timestamp = new Timestamp(customer.getJoinDate().getTimeInMillis());
        
        connection = DatabaseConnection.connection();
        String sql = "INSERT INTO customer" +  
                     " (id, name, email, password, join_date)" + 
                     " VALUES" + 
                     " (?,?,?,?,?);"; 
        try {
            prpStatement = connection.prepareStatement(sql);
            prpStatement.setInt(1, customer.getId());
            prpStatement.setString(2, customer.getName());
            prpStatement.setString(3, customer.getEmail());
            prpStatement.setString(4, customer.getPassword());
            prpStatement.setObject(5, timestamp);
            prpStatement.executeUpdate();
            prpStatement.close();
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        lastId = customer.getId();
        System.out.println("Records created successfully");
        
        return true;
    }

    /**
     * Remove customer object from the database
     *
     * @param id  customer's id
     * @return true if success
     * @throws CustomerNotFoundException  throws if there is no current customer object from the database
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        
        connection = DatabaseConnection.connection();
        int sql_result = 0;
        String sql = "DELETE from public.customer WHERE id = ?"; 
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

        throw new CustomerNotFoundException(id);
        
        /*
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
            }
        }
        throw new CustomerNotFoundException(id);
        */
    }

    /**
     * This method to authenticate login system
     *
     * @param email  customer's email
     * @param password  customer's password
     * @return customer if login success, null if authentication fail.
     */
    public static Customer customerLogin(String email, String password) {
       for (Customer customer : getCustomerDatabase()) {
            if (customer.getEmail().equals(email)  && customer.getPassword().equals(password)) {
                return customer;
            }
       }
       return null;
    }
}
