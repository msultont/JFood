
/**
 * Write a description of class CashInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice {
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashInvoice
     */
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus) {
        super(id, food, customer, invoiceStatus);
    }

    /**
     * 
     * @param y
     * @return
     */
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus,
            int deliveryFee) {
        super(id, food, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    /**
     * 
     */
    public int getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * 
     */
    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    /**
     * 
     */
    public void setTotalPrice() {
        if (getDeliveryFee() > 0) {
            super.totalPrice = super.getFood().getPrice() + getDeliveryFee();
        } else {
            super.totalPrice = super.getFood().getPrice();
        }
    }

    /**
     * 
     */
    public String toString() {

        if (getDeliveryFee() > 0) {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFood().getName() + "\nDate: " + super.getDate() + "\nCustomer: " + super.getCustomer().getName() + "\nDelivery Fee: " + getDeliveryFee() + "\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
            

        } else {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFood().getName() + "\nDate: " + super.getDate() + "\nCustomer: " + super.getCustomer().getName() + "\nTotal Price: " + super.getTotalPrice() + 
            "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
            
        }

    }
}
