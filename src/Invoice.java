import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/**
 * This class will generate the invoice receipt to the customer after they have
 * finished doing transaction in JFood restaurant.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public abstract class Invoice {
    // Instances Variables
    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;
    private SimpleDateFormat ft = new SimpleDateFormat("dd MMMM yyyy 'at' HH:mm:ss");
    protected String str;

    /**
     * Constructor for objects of class Invoice
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
     * 
     * @return
     */
    public ArrayList<Food> getFood() {
        return foods;
    }

    /**
     * This method will return the date of the invoice come out
     * 
     * @return date
     */
    public Calendar getDate() {
        return date;
    }
    
    /**
     * This method will return the total price all of the transaction in the invoice
     * 
     * @return totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method will return the spesific customer in the invoice. This will
     * return Customer data types which means it will call the object of the
     * Customer
     * 
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * 
     * @param id
     */
    public abstract PaymentType getPaymentType();

    /**
     * 
     * @return
     */
    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * This method will reasign the id of the invoice
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method will reasign the id of the food of the invoice
     * 
     * @param foods
     */
    public void setFood(ArrayList<Food> foods) {

    }

    /**
     * This method will reasign the date of the invoice come out
     * 
     * @param date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * 
     */
    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    /**
     * This method will reassign the total price of all transaction in the invoice
     * 
     * @param totalPrice
     */
    public abstract void setTotalPrice();

    /**
     * This method will reassign the customer in the invoice. This will call another
     * object to change the current customer
     * 
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * 
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * This method will print all the variables data to the terminal
     */
    public abstract String toString();

}
