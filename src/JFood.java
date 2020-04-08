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

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Sulton", "sulton@", "0822", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Jeky", "jeky@", "0812", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Boi", "boi@", "0899", location1));

        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Sulton", "msulton55@gmail.com", "sulto", new GregorianCalendar(TimeZone.getTimeZone("Asia/Jakarta"))));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"sulton","msulton55@gmail.com", "Sulton69", 2019, 5, 04));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Fathur", "fathur@gmail.com", "asdqwe123A"));
        //System.out.println(DatabaseCustomer.getCustomerDatabase());

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Jengkol", DatabaseSeller.getSellerDatabase().get(0), 20000, FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "pete", DatabaseSeller.getSellerDatabase().get(1), 40000, FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "kikil", DatabaseSeller.getSellerDatabase().get(2), 60000, FoodCategory.Bakery));
        //System.out.println(DatabaseFood.getFoodDatabase());

        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1 , "99promo1", 35000, 75000, false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "99promo1", 25000, 60000, true));
        //System.out.println(DatabasePromo.getPromoDatabase());

        ArrayList<Food> foods1 = new ArrayList<>();
        foods1.add(DatabaseFood.getFoodById(1));
        foods1.add(DatabaseFood.getFoodById(2));
        ArrayList<Food> foods2 = new ArrayList<>();
        foods2.add(DatabaseFood.getFoodById(2));
        foods2.add(DatabaseFood.getFoodById(3));

        
        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, foods1, DatabaseCustomer.getCustomerById(1), 15000));
        //System.out.println(DatabaseInvoice.getInvoiceDatabaseByCustomer());
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods2, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(2))); 
        for (Invoice i : DatabaseInvoice.getInvoiceByCustomer(1)) {
            i.setTotalPrice();
            i.setInvoiceStatus(InvoiceStatus.FINISHED);
        }
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods2, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(1)));
        DatabasePromo.getPromoById(1).setActive(true);
        for (Invoice i : DatabaseInvoice.getInvoiceDatabase()) {
            i.setTotalPrice();
        }
        //System.out.println(DatabaseSeller.getSellerDatabase());
        System.out.println(DatabaseInvoice.getInvoiceDatabase());
        //System.out.println(DatabaseInvoice.getInvoiceByCustomer(1));
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
