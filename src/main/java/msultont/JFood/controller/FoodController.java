package msultont.JFood.controller;
import msultont.JFood.*;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is all food's API for requesting the data into backend system.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@RequestMapping("/food")
@RestController
public class FoodController {

    @RequestMapping("")
    public String indexPage() {
        return "Hello, you are in the food lists page";
    }

    @RequestMapping(value = "/listFood", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) {
        Food food = null;
        try {
            food = DatabaseFood.getFoodById(id);
        } catch (FoodNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return food;
    }

    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        ArrayList<Food> foods = null;
        try {
            foods = DatabaseFood.getFoodBySeller(sellerId);
        } catch (SellerNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return foods;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        return DatabaseFood.getFoodByCategory(category);
    }

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public boolean addFood(@RequestParam(value = "name") String name, 
                        @RequestParam(value = "price") int price, 
                        @RequestParam(value = "category") FoodCategory category, 
                        @RequestParam(value = "sellerId") int sellerId) 
    {
        Food food = null;
        try {
            food = new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId), price, category);
        } catch (SellerNotFoundException e) {
            System.err.println(e.getMessage());
        }
        
        if (food != null) {
            DatabaseFood.addFood(food);
            return true;
        }
        
        return false;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean removeFood(@RequestParam(value = "food_id") int food_id) {
        boolean sql_result = false;
        try {
            sql_result = DatabaseFood.removeFood(food_id);
        } catch (FoodNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return sql_result;

    }

}