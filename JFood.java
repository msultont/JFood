import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * This is the main restaurant of JFood. Every object creation is created here
 * and all process is focused in this one class.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class JFood {

    public static void main(String[] args) {
        Customer customer1 = new Customer(10, "Sulton", ".msulton55@gmail.com", "sulto",
                new GregorianCalendar(TimeZone.getTimeZone("America/Los_Angeles")));
        Customer customer2 = new Customer(20, "Fathur", "msulton55@gmail.com", "Sulton69", 2019, 5, 04);
        Customer customer3 = new Customer(30, "Ateng", "atengwewewew@sad.com", "asdqwe123A");
        //customer1.toString();
        // customer2.toString();
        // customer3.toString();
        //location1.toString();
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);

        
    }

}
