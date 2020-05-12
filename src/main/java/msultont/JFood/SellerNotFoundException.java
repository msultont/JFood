package msultont.JFood;

/**
 * Exception class when specific seller object isnt found in Seller Database.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

public class SellerNotFoundException extends Exception {
    private int seller_error;

    /**
     *
     * @param seller_input  seller id
     */
    public SellerNotFoundException(int seller_input) {
        super("Seller ID: ");
        this.seller_error = seller_input;
    }

    public String getMessage() {
        return super.getMessage() + seller_error + " not found";
    }
}