package msultont.JFood;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main restaurant of JFood. Every object creation is created here
 * and all process is focused in this one class. This JFood will be set as
 * backend server. All frontend system will be handled by JFood_Android interface.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 * @since February 1st, 2020
 */

@SpringBootApplication
public class JFood {

    /**
     * Static main class to start the backend program.
     *
     * There are dummy object to present the data.
     *
     * @param args
     */
    public static void main(String[] args) {
        Location location1 = new Location("Tangerang", "Banten", "Pusat");
        Location location2 = new Location("Depok", "Jawa Barat", "Cabang-pusat");


        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Sulton", "sulton@gmail.com", "0822", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Jacky", "jacky@gmail.com", "0812", location2));

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Jus Mangga", DatabaseSeller.getSellerDatabase().get(0), 20000, FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Pastry", DatabaseSeller.getSellerDatabase().get(0), 60000, FoodCategory.Bakery));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Ramen", DatabaseSeller.getSellerDatabase().get(1), 125000, FoodCategory.Japanese));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, "Sushi", DatabaseSeller.getSellerDatabase().get(1), 150000, FoodCategory.Japanese));

        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "Sul55", 55000, 100000, true));
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "Promo55", 30000, 74000, true));
            
        } catch (PromoCodeAlreadyExistsException e) {
            e.printStackTrace();
        }
        
        SpringApplication.run(JFood.class, args);

    }

}
