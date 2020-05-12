package msultont.JFood;

/**
 * All list for payment type.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public enum PaymentType {
    Cashless("Cashless"), Cash("Cash");

    private String type;

    private PaymentType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
