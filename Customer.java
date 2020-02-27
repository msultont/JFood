
/**
 * The Customer class generate an object to create virtual customer for
 * restaurant called JFood. All information about customer data is generated
 * here.
 * 
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class Customer {

    // Instances Variables
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
     * This method will return Id number of customer
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This method will return name of customer
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method will return email of customer
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method will return password of customer
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method will return the joindate of customer to the restaurant
     * 
     * @return joinDate
     */
    public String getJoinDate() {
        return joinDate;
    }

    /**
     * This method will reassign the Id of customer
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method will reassign the name of customer
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method will reassign the email of customer
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method will reassign the password of customer
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method will reassign the joindate of customer to the restaurant
     * 
     * @param joinDate
     */
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * This method will print all the variables data to the terminal
     */
    public void printData() {
        System.out.println(id);
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);
        System.out.println(joinDate);
    }

}
