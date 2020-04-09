import java.util.ArrayList;

/**
 * Write a description of class DatabaseSeller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseSeller {
    // instance variables - replace the example below with your own
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Seller> getSellerDatabase() {
       return SELLER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Seller getSellerById(int id) throws SellerNotFoundException {
        for (Seller seller : SELLER_DATABASE) {
            if (seller.getId() == id) {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
    }

    /**
     *
     */
    public static boolean addSeller(Seller seller) {
        lastId = seller.getId();
        SELLER_DATABASE.add(seller);        
        return true;
    }

    /**
     * 
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException {
        for (Seller seller : SELLER_DATABASE) {
            if (seller.getId() == id) {
                SELLER_DATABASE.remove(seller);
                return true;
            }
        }
        throw new SellerNotFoundException(id);
    }
}
