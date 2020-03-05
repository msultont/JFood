
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum PaymentType {
    Cashless("Cashless"), Cash("Cash");

    private String type;

    private PaymentType(String type) {
        this.type = type;
    }

    /**
     * 
     */
    public String toString() {
        return type;
    }
}
