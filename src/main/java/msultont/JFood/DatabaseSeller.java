package msultont.JFood;
import java.util.ArrayList;

/**
 * This is database Seller class. Databases' class is intended as single object only.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 22th, 2020
 */
public class DatabaseSeller {
    // Global Variables
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Return all Seller object in the array.
     *
     * @return SELLER_DATABASE
     */
    public static ArrayList<Seller> getSellerDatabase() {
       return SELLER_DATABASE;
    }

    /**
     * Return the last ID of Seller class has been put into database
     *
     * @return lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Return the seller by its id.
     *
     * @param id  seller's id
     * @return seller
     * @throws SellerNotFoundException  if no seller's id, then throw this exception
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException {
        for (Seller seller : SELLER_DATABASE) {
            if (seller.getId() == id) {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
    }

    /**
     * Add new seller's object into database.
     *
     * @param seller  Seller's object
     * @return true indicating success
     */
    public static boolean addSeller(Seller seller) {
        lastId = seller.getId();
        SELLER_DATABASE.add(seller);        
        return true;
    }

    /**
     * Remove seller's object from database.
     *
     * @param id  seller's id
     * @throws SellerNotFoundException  throw exception if no seller's id
     * @return true if success
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
