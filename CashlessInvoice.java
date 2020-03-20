
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
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus) {
        super(id, food, customer, invoiceStatus);
    }

    /**
     * 
     */
    public CashlessInvoice(int id, Food food,  Customer customer, InvoiceStatus invoiceStatus,
            Promo promo) {
        super(id, food, customer, invoiceStatus);
        this.promo = promo;
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

        // This logic checks if there is promo object AND promo active status is true
        // AND price of the food is higher equal to minimal price from the promo.
        if (getPromo() != null && promo.getActive() == true && super.getFood().getPrice() >= promo.getMinPrice()) {
            super.totalPrice = super.getFood().getPrice() - promo.getDiscount();
            // Unless the top logic, this will execute another process.
        } else {
            super.totalPrice = super.getFood().getPrice();
        }

    }

    /**
     * 
     */
    @Override
    public String toString() {

        if (getPromo() == null || promo.getActive() == false || super.totalPrice < promo.getMinPrice()) {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFood().getName() + "\nDate: " + super.getDate() + "\nCustomer: " + super.getCustomer().getName() + "\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";
            

        } else {
            return "=========INVOICE========\n" + "ID: " + super.getId() + "\nFood: " + super.getFood().getName() + "\nDate: " + super.getDate() + "\nCustomer: " + super.getCustomer().getName() + "\nPromo: " + promo.getCode() + "\nDiscount: " + promo.getDiscount() + "\nBase Price: " + super.getFood().getPrice()+"\nTotal Price: " + super.getTotalPrice() + "\nStatus: " + super.getInvoiceStatus() + "\nPayment Type: " + PAYMENT_TYPE + "\n";

        }

    }
}
