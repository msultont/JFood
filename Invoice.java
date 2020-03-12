
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
    private Food food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus) {
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.invoiceStatus = invoiceStatus;
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
     * This method will return the id of the food of the invoice
     * 
     * @return idFood
     */
    public int getIdFood() {
        return food.getId();
    }

    /**
     * 
     * @return
     */
    public Food getFood() {
        return food;
    }

    /**
     * This method will return the date of the invoice come out
     * 
     * @return date
     */
    public String getDate() {
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
     * @param id
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
     * @param idFood
     */
    public void setIdFood(int idFood) {
        food.setId(idFood);
    }

    /**
     * This method will reasign the date of the invoice come out
     * 
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
    public abstract void printData();

}
