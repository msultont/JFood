package msultont.JFood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private static Connection connection;
    private static PreparedStatement prpStatement = null;
    private static Statement statement = null;
    private static int lastId = 0;

    /**
     * Return all food object
     * @return FOOD_DATABASE
     */
    public static ArrayList<Food> getFoodDatabase() {

        FOOD_DATABASE.clear();
        Seller seller = null;
        connection = DatabaseConnection.connection();
        String sql = "SELECT * FROM public.food;";

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                try {
                    seller = DatabaseSeller.getSellerById(rs.getInt("seller_id"));
                } catch (SellerNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                FOOD_DATABASE.add(new Food(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    seller, 
                    rs.getInt("price"), 
                    FoodCategory.valueOf(rs.getString("category"))));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return FOOD_DATABASE;
    }

    /**
     * Return the last id of food object that has been added into the database.
     * @return lastId
     */
    public static int getLastId() {
        for (Food food : getFoodDatabase())
            lastId = food.getId();
        return lastId;
    }

    /**
     * Return food object by its id
     * @param id  food's id
     * @return food
     * @throws FoodNotFoundException  throws if no food object in the database
     */
    public static Food getFoodById(int id) throws FoodNotFoundException{
        for (Food food : getFoodDatabase()) {
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
    public static ArrayList<Food> getFoodBySeller(int sellerId) throws SellerNotFoundException{
        FOOD_FILTERED_BY_SELLER.clear(); // Always reset the array to only show specific sellerId
        for (Food food : getFoodDatabase()) {
            if (food.getSeller().getId() == sellerId) {
                FOOD_FILTERED_BY_SELLER.add(food);
                return FOOD_FILTERED_BY_SELLER;
            }
        }
        throw new SellerNotFoundException(sellerId);
    }

    /**
     * Return all lists food in the database by its category
     * @param category  Enum class of FoodCategory
     * @return FOOD_FILTERED_BY_CATEGORY
     */
    public static ArrayList<Food> getFoodByCategory(FoodCategory category) {
        FOOD_FILTERED_BY_CATEGORY.clear();
        for (Food food : getFoodDatabase()) {
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
        
        connection = DatabaseConnection.connection();
        String sql = "INSERT INTO public.food " + 
                     "(id, name, seller_id, price, category) " + 
                     "VALUES " + 
                     "(?,?,?,?,?::food_category)";
        
        try {
            prpStatement = connection.prepareStatement(sql);
            prpStatement.setInt(1, food.getId());
            prpStatement.setString(2, food.getName());
            prpStatement.setInt(3, food.getSeller().getId());
            prpStatement.setInt(4, food.getPrice());
            prpStatement.setString(5, food.getCategory().toString());
            prpStatement.executeUpdate();
            prpStatement.close();
            connection.commit();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
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

        connection = DatabaseConnection.connection();
        int sql_result = 0;
        String sql = "DELETE from public.food WHERE id = ?";

        try {
            prpStatement = connection.prepareStatement(sql);
            prpStatement.setInt(1, id);
            sql_result = prpStatement.executeUpdate();
            prpStatement.close();
            connection.commit();
            connection.close();
            
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (sql_result == 1) {
            return true;
        }
        
        throw new FoodNotFoundException(id);
    }


}
