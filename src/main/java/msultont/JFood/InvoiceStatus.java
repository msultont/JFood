package msultont.JFood;

/**
 * All list for invoice status.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public enum InvoiceStatus {
    ONGOING("ONGOING"), FINISHED("FINISHED"), CANCELED("CANCELED");

    private String status;

    private InvoiceStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}
