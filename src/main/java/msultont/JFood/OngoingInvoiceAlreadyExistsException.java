package msultont.JFood;
/**
 * OngoingInvoiceAlreadyExistsException
 */
public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

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