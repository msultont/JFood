package msultont.JFood.controller;
import msultont.JFood.*;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FoodController
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

    @RequestMapping(value = "/FoodId{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id) {
        Food food = null;
        try {
            food = DatabaseFood.getFoodById(id);
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return food;
    }

    @RequestMapping(value = "/seller/SellerId{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        ArrayList<Food> foods = null;
        foods = DatabaseFood.getFoodBySeller(sellerId);
        return foods;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category) {
        return DatabaseFood.getFoodByCategory(category);
    }

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name") String name, 
                        @RequestParam(value = "price") int price, 
                        @RequestParam(value = "category") FoodCategory category, 
                        @RequestParam(value = "sellerId") int sellerId) 
    {
        Food food = null;
        try {
            food = new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId), price, category);
            DatabaseFood.addFood(food);
        } catch (SellerNotFoundException e) {
            System.out.println(e);
        }
        
        return food;
    }
}