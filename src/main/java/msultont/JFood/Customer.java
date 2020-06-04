package msultont.JFood;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.*;

/**
 * The model Customer class generate an object to create virtual customer for
 * restaurant called JFood. All information about customer data is generated
 * here.
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
    private Calendar joinDate;
    private SimpleDateFormat ft = new SimpleDateFormat("dd MMMM yyyy");

    /**
     * 
     * @param id
     * @param name
     * @param email
     * @param password
     * @param joinDate
     */
    public Customer(int id, String name, String email, String password, Timestamp joinDate) {
        Calendar calendarConverter = Calendar.getInstance();
        calendarConverter.setTimeInMillis(joinDate.getTime());
        calendarConverter.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password); 
        this.joinDate = calendarConverter;
    }

    /**
     * Constructor for objects of class Customer
     * @param id  customer's id
     * @param name  customer's name
     * @param email  customer's email
     * @param password  customer's password
     * @param joinDate  the date of customer first time join into restaurant
     */
    public Customer(int id, String name, String email, String password, Calendar joinDate) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }
    /**
     * Override constructor version of class Customer
     * @param id  customer's id
     * @param name  customer's name
     * @param email  customer's email
     * @param password  customer's password
     * @param year  the year of join date of customer
     * @param month  the month of join date of customer
     * @param dayOfMonth  the day-month-perspective of join date of customer
     */
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    /**
     * Override constructor of class Customer with joinDate assign automatically by the system
     * @param id  customer's id
     * @param name  customer's name
     * @param email  customer's email
     * @param password  customer's password
     */
    public Customer(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = new GregorianCalendar();
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
    public Calendar getJoinDate() {
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
     * This method will reassign the email of customer. There is regex to give correct parameter of name convention to
     * the system.
     * 
     * @param email  assign customer's email
     */
    public void setEmail(String email) {
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if (m.find()) {
            this.email = email;
        } else {
            this.email = "NULL";
        }
    }

    /**
     * This method will reassign the password of customer
     * 
     * @param password  customer's password
     */
    public void setPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        if (m.find()) {
            this.password = password;
        } else {
            this.password = "NULL";
        }
    }

    /**
     * This method will reassign the joindate of customer to the restaurant
     * 
     * @param joinDate  assign new join date of customer
     */
    public void setJoinDate(Calendar joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * Reassign the join date of customer with specific year, month and day of month
     *
     * @param year  year's of join
     * @param month  month's of join
     * @param dayOfMonth  day's of join
     */
    public void setJoinDate(int year, int month, int dayOfMonth) {
        this.joinDate = new GregorianCalendar(year, month - 1, dayOfMonth);
    }

    /**
     * This method will print all the variables data to the terminal
     */
    @Override
    public String toString() {

        if (joinDate != null) {
            String str = ft.format(joinDate.getTime());

            return "==========CUSTOMER==========\n" + "ID = " + id + "\n" + "Nama = " + name + "\n" + "Email = " + email + "\n" + "Password = " + password + "\n" + "Join Date = " + str + "\n";
        } else {
            return "ID = " + id + "\n" + "Nama = " + name + "\n" + "Email = " + email + "\n" + "Password = " + password + "\n";
        }

    }

}
