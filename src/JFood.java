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

        try {
            DatabaseSeller.getSellerById(4);
        } catch (SellerNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }

        
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Sulton", "msulton55@gmail.com", "sulto55", new GregorianCalendar(TimeZone.getTimeZone("Asia/Jakarta"))));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,"m jeky","jeky@gmail.com", "jeky69", 2019, 5, 04));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Fathur", "fathur@gmail.com", "asdqwe123A"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Joe", "Joe@", "joe12345"));
        } catch (EmailAlreadyExistsException e) {
            //TODO: handle exception
            System.out.println(e);
        } 
        try {
            DatabaseCustomer.getCustomerById(9);
        } catch (CustomerNotFoundException e) {
            System.out.println(e);
        }
        
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Jengkol", DatabaseSeller.getSellerDatabase().get(0), 20000, FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "pete", DatabaseSeller.getSellerDatabase().get(1), 40000, FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "kikil", DatabaseSeller.getSellerDatabase().get(2), 60000, FoodCategory.Bakery));
        try {
            DatabaseFood.getFoodById(6);    
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }

        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1 , "99promo1", 35000, 75000, true));
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "99promo2", 25000, 60000, true));   
            DatabasePromo.getPromoById(8); 
        } catch (PromoCodeAlreadyExistsException e) {
            //TODO: handle exception
            System.out.println(e);
        } catch (PromoNotFoundException e) {
            System.out.println(e);
        }

        ArrayList<Food> foods1 = new ArrayList<>();
        ArrayList<Food> foods2 = new ArrayList<>();
        ArrayList<Food> foods3 = new ArrayList<>();
        try {    
            foods1.add(DatabaseFood.getFoodById(1));
            foods1.add(DatabaseFood.getFoodById(2));    
            foods2.add(DatabaseFood.getFoodById(2));
            foods2.add(DatabaseFood.getFoodById(3));
            foods3.add(DatabaseFood.getFoodById(1));
            foods3.add(DatabaseFood.getFoodById(3));
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, foods1, DatabaseCustomer.getCustomerById(1), 15000));
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods2, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(2))); 
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods3, DatabaseCustomer.getCustomerById(3), DatabasePromo.getPromoById(2)));
            DatabasePromo.getPromoById(1).setActive(true);
        } catch (CustomerNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        } catch (PromoNotFoundException e) {
            System.out.println(e);
        }
        
        try {
            PriceCalculator calc1 = new PriceCalculator(DatabaseInvoice.getInvoiceById(1));
            PriceCalculator calc2 = new PriceCalculator(DatabaseInvoice.getInvoiceById(2));
            ;
            PriceCalculator calc3 = new PriceCalculator(DatabaseInvoice.getInvoiceById(3)); 
            calc1.start();
            calc2.start();
            calc3.start();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        //System.out.println(DatabaseCustomer.getCustomerDatabase());
        //System.out.println(DatabaseFood.getFoodDatabase());
        //System.out.println(DatabasePromo.getPromoDatabase());
        //System.out.println(DatabaseInvoice.getInvoiceDatabaseByCustomer());
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
