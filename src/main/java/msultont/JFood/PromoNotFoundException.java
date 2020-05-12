package msultont.JFood;

/**
 * Exception class when specific promo object isnt found in Invoice Database.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

public class PromoNotFoundException extends Exception{
    private int promo_error;

    /**
     * @param promo_input  promo id
     */
    public PromoNotFoundException(int promo_input) {
        super("Promo ID: ");
        this.promo_error = promo_input;
    }

    public String getMessage() {
        return super.getMessage() + promo_error + " not found";
    }
}