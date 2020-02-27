
/**
 * The Customer class generate an object to create virtual customer for restaurant called JFood.
 * 
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(int id, String name, String email, String password, String joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public int getId() {
        return id;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     */
    public String getJoinDate() {
        return joinDate;
    }

    /**
     * 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     */
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * 
     */
    public void printData() {

    }

}
