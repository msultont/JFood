
/**
 * Food class will generate the type of food and its name to the JFood
 * restaurant
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class Food {
    // Instances variable
    private int id;
    private String name;
    private Seller seller;
    private int price;
    private FoodCategory category;

    /**
     * Constructor for objects of class Food
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category) {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }

    /**
     * This method will return the id of the food
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This method will return the name of the food
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method will return the spesific information of the seller
     * 
     * @return seller
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * This method will return the price of the food
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method will return the category of the food
     * 
     * @return category
     */
    public FoodCategory getCategory() {
        return category;
    }

    /**
     * This method will reassign the id of the food
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method will reassign the name of the food
     * 
     * @param id
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method will reassign the seller's information by changing the object of
     * Seller
     * 
     * @param seller
     */
    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    /**
     * This method will reassign the price of the food
     * 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method will reassign the category of the food
     * 
     * @param category
     */
    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    /**
     * This method will print all the variables data to the terminal
     */
    @Override
    public String toString() {
        return "ID = " + id + "Nama = " + name + "Seller = " + getSeller().getName() + "City = "
                + getSeller().getLocation().getCity() + "Price = " + getPrice() + "Category = " + getCategory();

    }

}
