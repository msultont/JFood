
/**
 * Write a description of class Customer here.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class Invoice
{
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        return id;
    }

    /**
     * 
     */
    public int getIdFood() 
    {
        return idFood;
    }

    /**
     * 
     */
    public String getDate()
    {
        return date;
    }

    /**
     * 
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * 
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * 
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * 
     */
    public void setIdFood(int idFood)
    {
        this.idFood = idFood;
    }

    /**
     * 
     */
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * 
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    /**
     * 
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    /**
     * 
     */
    public void printData()
    {

    }

}
