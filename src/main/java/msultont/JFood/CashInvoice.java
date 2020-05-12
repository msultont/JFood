package msultont.JFood;
import java.util.ArrayList;

/**
 * This Invoice's child class is spesifically to CashInvoice.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class CashInvoice extends Invoice {
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Constructor for objects of class CashInvoice
     * @param id  invoice's id
     * @param foods  lists of food
     * @param customer  the current customer doing transaction
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer) {
        super(id, foods, customer);
    }

    /**
     * Override constructor with delivery fee
     * @param id  invoice's id
     * @param foods  lists of food
     * @param customer  the current customer doing transaction
     * @param deliveryFee the price of delivery fee
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer,
            int deliveryFee) {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    /**
     * Return the payment type of this invoice
     * @return PAYMENT_TYPE
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    /**
     * Return this object delivery fee
     * @return deliveryFee
     */
    public int getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * Assign new delivery fee into this object
     * @param deliveryFee  this object delivery fee
     */
    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    /**
     * Calculate all the food's price into the invoice with/without the delivery fee
     */
    public void setTotalPrice() {
        if (super.totalPrice == 0) {
            for (Food food : super.getFoods()) {
                super.totalPrice = super.totalPrice + food.getPrice();
            }
            super.totalPrice = super.totalPrice - super.previousTotalPrice;
            super.previousTotalPrice = super.totalPrice;
            if (getDeliveryFee() > 0) {
                super.totalPrice =  super.previousTotalPrice + getDeliveryFee();
            }
        } else {
            super.totalPrice = super.totalPrice - getDeliveryFee(); 
            for (Food food : super.getFoods()) {
                super.totalPrice = super.totalPrice + food.getPrice();
            }
            super.totalPrice = super.totalPrice - super.previousTotalPrice;
            super.previousTotalPrice = super.totalPrice;
            if (getDeliveryFee() > 0) 
                super.totalPrice =  super.previousTotalPrice + getDeliveryFee(); 
        }
    }

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
