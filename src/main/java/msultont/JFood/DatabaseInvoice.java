package msultont.JFood;
import java.util.ArrayList;
public class DatabaseInvoice {
    private static ArrayList<Invoice> DATABASE_INVOICE = new ArrayList<>();
    private static ArrayList<Invoice> DATABASE_INVOICE_BY_CUSTOMER = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase() {
        return DATABASE_INVOICE;
    }

    public static ArrayList<Invoice> getInvoiceDatabaseByCustomer() {
        return DATABASE_INVOICE_BY_CUSTOMER;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException{
        for (Invoice invoice : DATABASE_INVOICE) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
    
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        DATABASE_INVOICE_BY_CUSTOMER.clear();
        for (Invoice invoice : DATABASE_INVOICE) {
            if (invoice.getCustomer().getId() == customerId) { 
                DATABASE_INVOICE_BY_CUSTOMER.add(invoice);        
            }
        }
        return DATABASE_INVOICE_BY_CUSTOMER;
    }
    

    
    
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException {
        for (Invoice invoice1 : DATABASE_INVOICE) {
            if (invoice1.getCustomer().getId() == invoice.getCustomer().getId() && invoice1.getInvoiceStatus().equals(InvoiceStatus.ONGOING)) {
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }   
        }
        DATABASE_INVOICE.add(invoice);
        lastId = invoice.getId();
        return true;
    }
    

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException{
        for (Invoice invoice : DATABASE_INVOICE) {
            if (invoice.getId() == id) {
                DATABASE_INVOICE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for (Invoice invoice: DATABASE_INVOICE) {
            if (invoice.getId() == id && invoice.getInvoiceStatus() == InvoiceStatus.ONGOING) {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }
}