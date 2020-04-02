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
        Location location1 = new Location("Tangerang", "Banten", "Pusat");

        Seller seller1 = new Seller(5, "Sulton", "sulton@", "0822", location1);
        DatabaseSeller.addSeller(seller1);

        Customer customer1 = new Customer(10, "Sulton", "msulton55@gmail.com", "sulto",
                new GregorianCalendar(TimeZone.getTimeZone("Asia/Jakarta")));
        Customer customer2 = new Customer(20, "Sulton", "msulton55@gmail.com", "Sulton69", 2019, 5, 04);
        Customer customer3 = new Customer(30, "Fathur", "fathur@gmail.com", "asdqwe123A");
        DatabaseCustomer.addCustomer(customer1);
        DatabaseCustomer.addCustomer(customer2);
        DatabaseCustomer.addCustomer(customer3);
        System.out.println(DatabaseCustomer.getCustomerDatabase());

        Food food1 = new Food(100, "Jengkol", seller1, 50000, FoodCategory.Beverages);
        Food food2 = new Food(200, "pete", seller1, 30000, FoodCategory.Beverages);
        Food food3 = new Food(300, "kikil", DatabaseSeller.getSellerDatabase().get(0), 60000, FoodCategory.Bakery);
        DatabaseFood.addFood(food1);
        DatabaseFood.addFood(food2);
        DatabaseFood.addFood(food3);
        System.out.println(DatabaseFood.getFoodDatabase());

        //Promo promo1 = new Promo(99, "99promo1", 10000, 29999, true);

        //CashInvoice invoice1 = new CashInvoice(1, DatabaseFood.getFoodDatabase(), customer1);

        //CashlessInvoice invoice2 = new CashlessInvoice(2, DatabaseFood.getFoodDatabase(), customer2, promo1);

        //customer1.toString();
        // customer2.toString();
        // customer3.toString();
        //location1.toString();
        //System.out.println(customer1);
        //System.out.println(customer2);
        //System.out.println(customer3);
        //System.out.println(invoice1);
        //System.out.println(invoice2);
    }

}
