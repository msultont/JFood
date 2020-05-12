package msultont.JFood;

/**
 * This class create discount promo.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class Promo {
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
     * Constructor for objects of class Promo
     * @param id  promo id
     * @param code  promo code
     * @param discount  promo discount
     * @param minPrice  minimal price to activate promo
     * @param active  promo status
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }

    /**
     * Return promo id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Return promo code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Return promo discount
     *
     * @return discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Return promo minimal price
     *
     * @return minPrice
     */
    public int getMinPrice() {
        return minPrice;
    }

    /**
     * Return promo status
     *
     * @return active
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Assign new promo id
     *
     * @param id  promo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Assign new promo code
     *
     * @param code  promo code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Assign new promo discount
     *
     * @param discount  promo discount
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Assign new promo minimum price
     *
     * @param minPrice  promo minimum price
     */
    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * Assign new promo status
     *
     * @param active  promo status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "==========PROMO==========\n" + "\nID = " + id + "\nKode = " + code + "\nDiskon = " + discount + "\nMin price = " + minPrice + "\nActive status = "
                + getActive();

    }
}
