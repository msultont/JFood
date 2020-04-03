import java.util.ArrayList;
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

        Seller seller1 = new Seller(DatabaseSeller.getLastId()+1, "Sulton", "sulton@", "0822", location1);
        DatabaseSeller.addSeller(seller1);

        Customer customer1 = new Customer(DatabaseCustomer.getLastId()+1, "Sulton", "msulton55@gmail.com", "sulto", new GregorianCalendar(TimeZone.getTimeZone("Asia/Jakarta")));
        DatabaseCustomer.addCustomer(customer1);
        Customer customer2 = new Customer(DatabaseCustomer.getLastId()+1,"sulton","msulton55@gmail.com", "Sulton69", 2019, 5, 04);
        DatabaseCustomer.addCustomer(customer2);
        Customer customer3 = new Customer(DatabaseCustomer.getLastId()+1, "Fathur", "fathur@gmail.com", "asdqwe123A");
        DatabaseCustomer.addCustomer(customer3);
        //System.out.println(DatabaseCustomer.getCustomerDatabase());

        Food food1 = new Food(DatabaseFood.getLastId()+1, "Jengkol", seller1, 20000, FoodCategory.Beverages);
        DatabaseFood.addFood(food1);
        Food food2 = new Food(DatabaseFood.getLastId()+1, "pete", seller1, 40000, FoodCategory.Beverages);
        DatabaseFood.addFood(food2);
        Food food3 = new Food(DatabaseFood.getLastId()+1, "kikil", DatabaseSeller.getSellerDatabase().get(0), 60000, FoodCategory.Bakery);
        DatabaseFood.addFood(food3);
        //System.out.println(DatabaseFood.getFoodDatabase());
        Promo promo1 = new Promo(DatabasePromo.getLastId()+1 , "99promo1", 10000, 29999, false);
        DatabasePromo.addPromo(promo1);
        Promo promo2 = new Promo(DatabasePromo.getLastId()+1, "99promo1", 15000, 30000, true);
        DatabasePromo.addPromo(promo2);
        //System.out.println(DatabasePromo.getPromoDatabase());

        ArrayList<Food> foods1 = new ArrayList<>();
        foods1.add(food1);
        ArrayList<Food> foods2 = new ArrayList<>();
        foods1.add(food2);

        
        CashInvoice invoice1 = new CashInvoice(DatabaseInvoice.getLastId()+1, foods1, DatabaseCustomer.getCustomerById(1), 15000);
        DatabaseInvoice.addInvoice(invoice1);
        for (Invoice i : DatabaseInvoice.getInvoiceByCustomer(1)) {
            i.setTotalPrice();
        }
        CashlessInvoice invoice2 = new CashlessInvoice(DatabaseInvoice.getLastId()+1, DatabaseFood.getFoodDatabase(), customer1);
        DatabaseInvoice.addInvoice(invoice2);
        for (Invoice i : DatabaseInvoice.getInvoiceByCustomer(2)) {
            i.setTotalPrice();
        }
        System.out.println(DatabaseInvoice.getInvoiceDatabase());

        //System.out.println(invoice1);

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
