package msultont.JFood;

/**
 * Food model to present detail information about food in the restaurant.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class Food {
    // Instances variable
    private int id;
    private String name;
    private Seller seller;
    private int price;
    private FoodCategory category;

    /**
     * Food constructor.
     *
     * @param id food's id
     * @param name food's name
     * @param seller food's seller distributor. Must have Seller object.
     * @param price food's price
     * @param category food's category. Based on FoodCategory enum class.
     * @see FoodCategory
     * @see Seller
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category) {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }

    /**
     * Return food's id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Return food's name.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Return food's seller distributor
     * 
     * @return seller
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * Return food's price.
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return food's category.
     * 
     * @return category
     */
    public FoodCategory getCategory() {
        return category;
    }

    /**
     * Assign new food's id.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Assign new food's name.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Assign new food's seller distributor object.
     * 
     * @param seller
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * Assign new food's price.
     * 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Assign new food's category.
     * 
     * @param category
     */
    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    /**
     * Override toString() method to print all information about this food.
     */
    @Override
    public String toString() {
        return "==========FOOD==========\n" + "ID = " + id + "\nNama = " + name + "\nSeller = " + getSeller().getName() + "\nCity = "
                + getSeller().getLocation().getCity() + "\nPrice = " + getPrice() + "\nCategory = " + getCategory();

    }

}
