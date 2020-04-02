import java.util.ArrayList;

/**
 * Database Food class is the class to generate all possible food then collected
 * in this class
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class DatabaseFood {
    // Instances variable
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<>();
    private static ArrayList<Food> FOOD_FILTERED_BY_SELLER = new ArrayList<>();
    private static ArrayList<Food> FOOD_FILTERED_BY_CATEGORY = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Food> getFoodDatabase() {
        return FOOD_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Food getFoodById(int id) {
        for (Food food : FOOD_DATABASE) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId) {
        for (Food food : FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                FOOD_FILTERED_BY_SELLER.add(food);
                return FOOD_FILTERED_BY_SELLER;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        for (Food food : FOOD_DATABASE) {
            if (food.getCategory() == category) {
                FOOD_FILTERED_BY_CATEGORY.add(food);
                return FOOD_FILTERED_BY_CATEGORY;
            }
        }
        return null;
    }

    /**
     *
     */
    public static boolean addFood(Food food) {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    /**
     * This method will check whether the current object of food exist. If it
     * exists, the method will return boolean value of true
     * 
     * @param id
     * @return true
     */
    public static boolean removeFood(int id) {
        for (Food food : FOOD_DATABASE) {
            if (food.getId() == id) {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        return false;
    }


}
