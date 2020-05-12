package msultont.JFood;

/**
 * Exception class when specific promo code has already existed in Promo Database.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

public class PromoCodeAlreadyExistsException extends Exception{
    private Promo promo_error;

    /**
     *
     * @param promo_input  promo object
     */
    public PromoCodeAlreadyExistsException(Promo promo_input) {
        super("Promo Code: ");
        this.promo_error = promo_input;
    }

    public String getMessage() {
        return super.getMessage() + promo_error.getCode() + " already exists";
    }
}