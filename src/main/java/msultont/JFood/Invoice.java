package msultont.JFood;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Invoice abstract class provides general information to be used by its inherited class: CashInvoice and Cashless
 * Invoice. This class will create invoice after there is transaction done in the restaurant.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public abstract class Invoice {
    // Instances Variables
    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    protected int previousTotalPrice = 0;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;
    private SimpleDateFormat ft = new SimpleDateFormat("dd MMMM yyyy 'at' HH:mm:ss");
    protected String str; // variable to save the date format.

    /**
     * Constructor for objects of class Invoice
     * @param id  Invoice id
     * @param foods  Lists of all food in the invoice.
     * @param customer  the customer who does transaction within the invoice.
     */
    public Invoice(int id, ArrayList<Food> foods, Customer customer) {
        this.id = id;
        this.foods = foods;
        this.invoiceStatus = InvoiceStatus.ONGOING;
        this.customer = customer;
        this.date = new GregorianCalendar(TimeZone.getTimeZone("Asia/Jakarta"));
        this.str = ft.format(date.getTime());
    }

    /**
     * This method will return the id of the invoice
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Return lists of all food within this invoice.
     * @return foods
     */
    public ArrayList<Food> getFoods() {
        return foods;
    }

    /**
     * This method will return the date of the first time this invoice is created.
     * 
     * @return date
     */
    public Calendar getDate() {
        return date;
    }
    
    /**
     * This method will return the total price all of the transaction in the invoice.
     * 
     * @return totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method will return the spesific customer in the invoice doing the transaction.
     *
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Payment type will be inherited whether CashInvoice or CashlessInvoice.
     * @see PaymentType
     */
    public abstract PaymentType getPaymentType();

    /**
     * Return the invoice status of the invoice.
     * @return invoiceStatus
     * @see InvoiceStatus
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * This method will reasign the id of the invoice
     * 
     * @param id  set invoice id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method will add new food into the list of foods of customer invoice transaction.
     * @param food
     */
    public void setFoods(Food food) {
        foods.add(food);
    }

    /**
     * This method will reasign the date of the invoice creation time using Calendar object.
     * 
     * @param date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Specify the date based on year, month and dayOfMonth.
     *
     * @param year  current year
     * @param month current month
     * @param dayOfMonth  current day of date based on date of month.
     * @see GregorianCalendar
     */
    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    /**
     * This method will reassign the total price of all transaction in the invoice.
     *
     */
    public abstract void setTotalPrice();

    /**
     * This method will reassign the customer in the invoice. This will call another
     * object to change the current customer
     * 
     * @param customer  change the customer within the invoice.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Reassign the invoice status based of transaction condition.
     * @param invoiceStatus  Change invoice status based of InvoiceStatus enum
     * @see InvoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * This method will print all the variables data to the terminal
     */
    public abstract String toString();

}
