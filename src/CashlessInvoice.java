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

        for (Food food : getFood()) {
            // This logic checks if there is promo object AND promo active status is true
            // AND price of the food is higher equal to minimal price from the promo.
            if (getPromo() != null && promo.getActive() == true && super.getTotalPrice()  > promo.getMinPrice()) {
                super.totalPrice = food.getPrice() - promo.getDiscount();
                // Unless the top logic, this will execute another process.
            } else {
                super.totalPrice = food.getPrice();
            }
        }



    }

    /**
     * 
     */
    @Override
    public String toString() {
        for (Food food : getFood()) {
            if (getPromo() != null && promo.getActive() == true && super.totalPrice < promo.getMinPrice()) {
                return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + food.getName() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nPromo: " + promo.getCode() + "\nDiscount: " + promo.getDiscount() + "\nBase Price: " + food.getPrice()+"\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
            } else {
                return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFood() + "\nDate: " + str + "\nCustomer: " + super.getCustomer().getName() + "\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";

            }
        }
        return "berhasil";
    }
}
