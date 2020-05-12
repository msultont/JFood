package msultont.JFood;
import java.util.ArrayList;

/**
 * Database Food class is the class to save all list's food of restaurant.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class DatabaseFood {
    // Global variable
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();
    private static ArrayList<Food> FOOD_FILTERED_BY_SELLER = new ArrayList<>();
    private static ArrayList<Food> FOOD_FILTERED_BY_CATEGORY = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Return all food object
     * @return FOOD_DATABASE
     */
    public static ArrayList<Food> getFoodDatabase() {
        return FOOD_DATABASE;
    }

    /**
     * Return the last id of food object that has been added into the database.
     * @return lastId
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Return food object by its id
     * @param id  food's id
     * @return food
     * @throws FoodNotFoundException  throws if no food object in the database
     */
    public static Food getFoodById(int id) throws FoodNotFoundException{
        for (Food food : FOOD_DATABASE) {
            if (food.getId() == id) {
                return food;
            }
        }
        throw new FoodNotFoundException(id);
    }

    /**
     * Return all lists food in the database by its seller's id
     *
     * @param sellerId  seller's id
     * @return FOOD_FILTERED_BY_SELLER
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId) {
        FOOD_FILTERED_BY_SELLER.clear(); // Always reset the array to only show specific sellerId
        for (Food food : FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                FOOD_FILTERED_BY_SELLER.add(food);
            }
        }
        return FOOD_FILTERED_BY_SELLER;
    }

    /**
     * Return all lists food in the database by its category
     * @param category  Enum class of FoodCategory
     * @return FOOD_FILTERED_BY_CATEGORY
     */
    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        FOOD_FILTERED_BY_CATEGORY.clear();
        for (Food food : FOOD_DATABASE) {
            if (food.getCategory() == category) {
                FOOD_FILTERED_BY_CATEGORY.add(food);
                
            }
        }
        return FOOD_FILTERED_BY_CATEGORY;
    }

    /**
     * Add new food object into the database
     * @param food  food's object
     * @return true if success
     */
    public static boolean addFood(Food food) {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    /**
     * This will remove food's object from the database
     * 
     * @param id  food's id
     * @return true if success
     * @throws FoodNotFoundException  throws if there is no current food object from the Food Database
     */
    public static boolean removeFood(int id) throws FoodNotFoundException{
        for (Food food : FOOD_DATABASE) {
            if (food.getId() == id) {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        throw new FoodNotFoundException(id);
    }


}
