import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseCustomer {
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Customer> getCustomerDatabase() {
        return CUSTOMER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Customer getCustomerById(int id) {
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param customer a sample parameter for a method
     * @return the sum of x and y
     */
    public static boolean addCustomer(Customer customer) {
        for (Customer customer1 : CUSTOMER_DATABASE) {
            if (customer1.getEmail().equals(customer.getEmail())) {
                return false;
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    /**
     * 
     */
    public static boolean removeCustomer(int id) {
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        return false;
    }
}
