package msultont.JFood;
import java.util.ArrayList;

/**
 * This customer database to save all customer information
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class DatabaseCustomer {
    // Global Variables
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Return all customer object
     * @return CUSTOMER_DATABASE
     */
    public static ArrayList<Customer> getCustomerDatabase() {
        return CUSTOMER_DATABASE;
    }

    /**
     * Return the last id of food's object added into the database
     * @return lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Return customer object by its id
     * @param id  customer's id
     * @return customer
     * @throws CustomerNotFoundException  throws if no customer's object
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException {
        for (Customer customer : CUSTOMER_DATABASE) {
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
        for (Customer customer1 : CUSTOMER_DATABASE) {
            if (customer1.getEmail().equals(customer.getEmail())) {
                throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
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
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * This method to authenticate login system
     *
     * @param email  customer's email
     * @param password  customer's password
     * @return customer if login success, null if authentication fail.
     */
    public static Customer customerLogin(String email, String password) {
       for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getEmail().equals(email)  && customer.getPassword().equals(password)) {
                return customer;
            }
       }
       return null;
    }
}
