package msultont.JFood;

/**
 * Exception class when specific customer email has already existed in database.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@SuppressWarnings("serial")
public class EmailAlreadyExistsException extends Exception{
    private Customer customer_error;

    /**
     *
     * @param customer_input  customer object
     */
    public EmailAlreadyExistsException(Customer customer_input) {
        super("Customer Email: ");
        this.customer_error = customer_input;
    }

    public String getMessage() {
        return super.getMessage() + customer_error.getEmail() + " already exists";
    }

}