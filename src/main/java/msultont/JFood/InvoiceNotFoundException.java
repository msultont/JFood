package msultont.JFood;

/**
 * Exception class when specific invoice object isn't found.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@SuppressWarnings("serial")
public class InvoiceNotFoundException extends Exception {
    private int invoice_error;

    /**
     * @param invoice_input  input the invoice id to show the error
     */
    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID: ");
        this.invoice_error = invoice_input;
    }

    public String getMessage() {
        return super.getMessage() + invoice_error + " not found";
    }
}