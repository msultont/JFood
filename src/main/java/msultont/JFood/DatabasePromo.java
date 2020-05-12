package msultont.JFood;
import java.util.ArrayList;
/**
 * This is database Promo class. Databases' class is intended as single object only.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 22th, 2020
 */
public class DatabasePromo {
    // Global Variables
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Return all promo objects in the array.
     *
     * @return PROMO_DATABASE
     */
    public static ArrayList<Promo> getPromoDatabase() {
        return PROMO_DATABASE;
    }

    /**
     * Return the last ID of Promo class has been put into database
     *
     * @return lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Return the promo object by its id
     *
     * @param id  promo's id
     * @return promo
     * @throws PromoNotFoundException  throws if there is no promo object
     */
    public static Promo getPromoById(int id) throws PromoNotFoundException {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }

    /**
     * Return the promo by its code
     *
     * @param code  promo's code
     * @return promo
     */
    public static Promo getPromoByCode(String code) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getCode().equals(code) ) {
                return promo;
            }
        }
        return null;
    }

    /**
     * Add new promo object into database.
     *
     * @param promo  new promo object
     * @return true if success
     * @throws PromoCodeAlreadyExistsException  throws if current promo object has been added in the database
     */
    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException {
        for (Promo promo1 : PROMO_DATABASE) {
            if (promo1.getCode().equals(promo.getCode())) {
                throw new PromoCodeAlreadyExistsException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }

    /**
     * Activate promo if promo status is false
     *
     * @param id  promo's id
     * @return true if success, false if no promo's id in database
     */
    public static boolean activatePromo(int id) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Deactivate promo if promo status is true
     *
     * @param id promo's id
     * @return true if success, false if no promo's id in database
     */
    public static boolean deactivatePromo(int id) {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove promo object in database
     *
     * @param id  promo's id
     * @throws PromoNotFoundException  throws if no promo's object in the database
     * @return true if success
     */
    public static boolean removePromo(int id) throws PromoNotFoundException {
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }


}
