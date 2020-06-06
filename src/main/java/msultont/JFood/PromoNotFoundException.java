package msultont.JFood;

/**
 * Exception class when specific promo object isnt found in Invoice Database.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@SuppressWarnings("serial")
public class PromoNotFoundException extends Exception{
    private String promo_error;

    /**
     * @param promo_input  promo id
     */
    public PromoNotFoundException(int promo_input) {
        super("Promo ID: ");
        this.promo_error = String.valueOf(promo_input);
    }

    /**
     * 
     */
    public PromoNotFoundException(String promo_input) {
        super("Promo with code: ");
        this.promo_error = promo_input;
    }

    public String getMessage() {
        return super.getMessage() + promo_error + " not found";
    }
}