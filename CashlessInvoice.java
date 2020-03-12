
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
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus) {
        super(id, food, date, customer, invoiceStatus);
    }

    /**
     * 
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus,
            Promo promo) {
        super(id, food, date, customer, invoiceStatus);
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

        if (promo != null && promo.getActive() == true && super.getFood().getPrice() > promo.getMinPrice()) {
            super.totalPrice = super.getFood().getPrice() - promo.getDiscount();
        } else {
            super.totalPrice = super.getFood().getPrice();
        }

    }

    /**
     * 
     */
    public void printData() {

        if ((promo == null && promo.getActive() == false) || super.getFood().getPrice() < promo.getMinPrice()) {
            System.out.print("kosong");
        } else {
            System.out.println("=========INVOICE========");
            System.out.println("Food: " + super.getFood().getName());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + super.getCustomer().getName());
            System.out.println("Total Price: " + super.getTotalPrice());
            System.out.println("Status: " + super.getInvoiceStatus());
            System.out.println("Payment Type: " + PAYMENT_TYPE);

        }

    }
}
