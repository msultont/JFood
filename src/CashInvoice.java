import java.util.ArrayList;

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
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer) {
        super(id, foods, customer);
    }

    /**
     * 
     * @param
     * @return
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer,
            int deliveryFee) {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *
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
        for (Food food : super.getFoods()) {
            super.totalPrice = super.totalPrice + food.getPrice();
        }
        if (getDeliveryFee() > 0) {
            super.totalPrice = super.totalPrice + getDeliveryFee();
        }

    }

    /**
     * 
     */
    @Override
    public String toString() {
        if (getDeliveryFee() > 0) {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFoods() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nDelivery Fee: " + getDeliveryFee() + "\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
            

        } else {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFoods() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nTotal Price: " + super.getTotalPrice() +
            "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
            
        }

    }
}
