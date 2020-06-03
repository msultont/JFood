package msultont.JFood;
import java.util.ArrayList;
/**
 * This is database Invoice class. Databases' class is intended as single object only.
 * This database will save CashInvoice and CashlessInvoice child class.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 22th, 2020
 */
public class DatabaseInvoice {
    // Global Variables
    private static ArrayList<Invoice> DATABASE_INVOICE = new ArrayList<>();
    private static ArrayList<Invoice> DATABASE_INVOICE_BY_CUSTOMER = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Return all invoices in the database
     * @return DATABASE_INVOICE
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        return DATABASE_INVOICE;
    }

    /**
     * Return all invoices based of customer preferences
     * @return DATABASE_INVOICE_BY_CUSTOMER
     */
    public static ArrayList<Invoice> getInvoiceDatabaseByCustomer() {
        return DATABASE_INVOICE_BY_CUSTOMER;
    }

    /**
     *  Return the last ID of Invoice object has been put into database
     * @return lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Return invoice object by its id
     * @param id  Invoice's id
     * @return invoice
     * @throws InvoiceNotFoundException  throws if no invoice object
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException{
        for (Invoice invoice : DATABASE_INVOICE) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * Return all invoice object selected by theirs customer id
     *
     * @param customerId  customer's id
     * @return DATABASE_INVOICE_BY_CUSTOMER
     */
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        DATABASE_INVOICE_BY_CUSTOMER.clear(); // Always reset the array to show only the spesific customerId.
        for (Invoice invoice : DATABASE_INVOICE) {
            if (invoice.getCustomer().getId() == customerId) { 
                DATABASE_INVOICE_BY_CUSTOMER.add(invoice);        
            }
        }
        return DATABASE_INVOICE_BY_CUSTOMER;
    }

    /**
     * Add new invoice object into database
     *
     * @param invoice  invoice object
     * @return true if success
     * @throws OngoingInvoiceAlreadyExistsException  throw if current invoice object has already added into the database.
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        if (!getInvoiceDatabase().isEmpty()) {
            for (Invoice invoice1 : DATABASE_INVOICE) {
                if (invoice1.getCustomer().getId() == invoice.getCustomer().getId() && invoice1.getInvoiceStatus().equals(InvoiceStatus.ONGOING)) {
                    throw new OngoingInvoiceAlreadyExistsException(invoice);
                }   
            } 
        } 
        DATABASE_INVOICE.add(invoice);
        lastId = invoice.getId();
        return true;
        
    }

    /**
     * Remove invoice object from the database
     * @param id  invoice's id
     * @return  true if success
     * @throws InvoiceNotFoundException  throws if current invoice object isn't found in the database
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        for (Invoice invoice : DATABASE_INVOICE) {
            if (invoice.getId() == id) {
                DATABASE_INVOICE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * Change current invoice status in the database depends on the condition.
     * This only accept if current invoice status is ongoing state.
     * @param id  invoice's id in the database
     * @param invoiceStatus  new status wants to be changed
     * @return true if success, false if the invoice isnt at ongoing status/state.
     */
    public static boolean changeInvoiceStatusById(int id, InvoiceStatus invoiceStatus) {
        for (Invoice invoice: DATABASE_INVOICE) {
            if (invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.ONGOING)) {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    public static boolean changeInvoiceStatusByCustomerId(int customerId, InvoiceStatus invoiceStatus) {
        for (Invoice invoice : getInvoiceByCustomer(customerId)) {
            if (invoice.getInvoiceStatus().equals(InvoiceStatus.ONGOING)) {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }
}