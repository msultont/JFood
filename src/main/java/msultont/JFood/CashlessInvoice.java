package msultont.JFood;
import java.util.ArrayList;

/**
 * This Invoice's child class is spesifically to CashlessInvoice.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class CashlessInvoice extends Invoice {
    // Instances variables and static variable
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     * @param id  invoice's id
     * @param foods  lists of food
     * @param customer  the current customer doing transaction
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer) {
        super(id, foods, customer);
    }

    /**
     * Override constructor with promo object
     * @param id  invoice's id
     * @param foods  lists of food
     * @param customer  the current customer doing transaction
     * @param promo  promo object
     */
    public CashlessInvoice(int id, ArrayList<Food> foods,  Customer customer,
            Promo promo) {
        super(id, foods, customer);
        this.promo = promo;
    }

    /**
     * Return the payment type of this invoice
     * @return PAYMENT_TYPE
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    /**
     * Return promo object
     * @return promo
     */
    public Promo getPromo() {
        return promo;
    }

    /**
     * Assign new promo object to the invoice
     * @param promo  new promo's object
     */
    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    /**
     * Calculate all the food's price into the invoice with/without the promo discount
     */
    public void setTotalPrice() {
        if (super.totalPrice == 0) {
            for (Food food : super.getFoods()) {
                // This logic checks if there is promo object AND promo active status is true
                // AND price of the total food is higher than the minimal price from the promo.
                super.totalPrice = super.totalPrice + food.getPrice();
            }
            super.totalPrice = super.totalPrice - super.previousTotalPrice;
            super.previousTotalPrice = super.totalPrice;
            if (getPromo() != null && getPromo().getActive() && super.getTotalPrice() > getPromo().getMinPrice())
                super.totalPrice = super.previousTotalPrice  - getPromo().getDiscount();
                // Unless the top logic, this will execute another process.
            
        } else {
            super.totalPrice = super.totalPrice + getPromo().getDiscount(); 
            for (Food food : super.getFoods()) {
                // This logic checks if there is promo object AND promo active status is true
                // AND price of the total food is higher than the minimal price from the promo.
                super.totalPrice = super.totalPrice + food.getPrice();
            }
            super.totalPrice = super.totalPrice - super.previousTotalPrice;
            super.previousTotalPrice = super.totalPrice;
            if (getPromo() != null && getPromo().getActive() && super.getTotalPrice() > getPromo().getMinPrice())
                super.totalPrice = super.previousTotalPrice  - getPromo().getDiscount();
                // Unless the top logic, this will execute another process.
        }

        
    }

    @Override
    public String toString() {
        if (getPromo() != null && getPromo().getActive() == true && super.totalPrice > promo.getMinPrice()) {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFoods() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nPromo: " + getPromo().getCode() + "\nDiscount: " + getPromo().getDiscount() + "\nBase Price: " + (super.getTotalPrice()+getPromo().getDiscount()) +"\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
        } else {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFoods() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";

        }
    }
}
