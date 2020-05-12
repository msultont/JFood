package msultont.JFood;

/**
 * Exception class when specific customer object isn't found in the customer database
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

public class CustomerNotFoundException extends Exception{
    private int customer_error;

    /**
     * @param customer_input  customer's id
     */
    public CustomerNotFoundException(int customer_input) {
        super("Customer ID: ");
        this.customer_error = customer_input;
    }

    public String getMessage() {
        return super.getMessage() + customer_error + " not found";
    }
}