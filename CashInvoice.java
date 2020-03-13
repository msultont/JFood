
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
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus) {
        super(id, food, date, customer, invoiceStatus);
    }

    /**
     * 
     * @param y
     * @return
     */
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus,
            int deliveryFee) {
        super(id, food, date, customer, invoiceStatus);
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
    public void printData() {
        if (getDeliveryFee() > 0) {
            System.out.println("=========INVOICE========");
            System.out.println("ID: " + super.getId());
            System.out.println("Food: " + super.getFood().getName());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + super.getCustomer().getName());
            System.out.println("Delivery Fee: " + getDeliveryFee());
            System.out.println("Total Price: " + super.getTotalPrice());
            System.out.println("Status: " + super.getInvoiceStatus());
            System.out.println("Payment Type: " + PAYMENT_TYPE);
            System.out.println("");

        } else {
            System.out.println("=========INVOICE========");
            System.out.println("ID: " + super.getId());
            System.out.println("Food: " + super.getFood().getName());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + super.getCustomer().getName());
            System.out.println("Total Price: " + super.getTotalPrice());
            System.out.println("Status: " + super.getInvoiceStatus());
            System.out.println("Payment Type: " + PAYMENT_TYPE);
            System.out.println("");
        }

    }
}
