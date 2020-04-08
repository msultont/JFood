import java.util.ArrayList;

/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashlessInvoice extends Invoice {
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer) {
        super(id, foods, customer);
        setTotalPrice();
    }

    /**
     * 
     */
    public CashlessInvoice(int id, ArrayList<Food> foods,  Customer customer,
            Promo promo) {
        super(id, foods, customer);
        this.promo = promo;
        setTotalPrice();
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
    public Promo getPromo() {
        return promo;
    }

    /**
     * 
     */
    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    /**
     * 
     */
    public void setTotalPrice() {
        for (Food food : super.getFoods()) {
            // This logic checks if there is promo object AND promo active status is true
            // AND price of the total food is higher than the minimal price from the promo.
            super.totalPrice = super.totalPrice + food.getPrice();
        }
        if (getPromo() != null && getPromo().getActive() == true && super.getTotalPrice() > getPromo().getMinPrice()) {
            super.totalPrice = super.totalPrice - getPromo().getDiscount();
            // Unless the top logic, this will execute another process.
        }
    }

    /**
     * 
     */
    @Override
    public String toString() {
        if (getPromo() != null && getPromo().getActive() == true && super.totalPrice > promo.getMinPrice()) {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFoods() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nPromo: " + getPromo().getCode() + "\nDiscount: " + getPromo().getDiscount() + "\nBase Price: " + (super.getTotalPrice()+getPromo().getDiscount()) +"\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
        } else {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFoods() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";

        }
    }
}
