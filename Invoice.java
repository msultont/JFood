
/**
 * This class will generate the invoice receipt to the customer after they have
 * finished doing transaction in JFood restaurant.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class Invoice {
    // Instances Variables
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice, InvoiceStatus status) {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.status = status;
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
        return idFood;
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
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * 
     * @param id
     */
    public InvoiceStatus getInvoiceStatus() {
        return status;
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
        this.idFood = idFood;
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
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

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
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 
     */
    public void setInvoiceStatus(InvoiceStatus status) {
        this.status = status;
    }

    /**
     * This method will print all the variables data to the terminal
     */
    public void printData() {
        System.out.println("===========INVOICE============");
        System.out.println("ID: " + id);
        System.out.println("Food ID: " + idFood);
        System.out.println("Date: " + date);
        System.out.println("Customer: " + getCustomer().getName());
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Status: " + getInvoiceStatus());
    }

}
