package msultont.JFood;

/**
 * Exception class when specific invoice with status ongoing already exist in Invoice Database.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@SuppressWarnings("serial")
public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    /**
     *
     * @param invoice_input  input invoice object.
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Ongoing Invoice ID: ");
        this.invoice_error = invoice_input;
    }

    public String getMessage() {
        String message = "";
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase()) {
            if (invoice.getCustomer().getId() == invoice_error.getCustomer().getId()) {
                message = super.getMessage() + invoice.getId() + " with customer ID " + invoice.getCustomer().getId() + " is on process";
            }
        }
        return message; 
    }
    
}