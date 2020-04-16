package msultont.JFood.controller;
import msultont.JFood.*;
import java.util.ArrayList;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood() {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(int id) {
        try {
            return DatabaseFood.getFoodById(id);
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    @RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(int sellerId) {
        return DatabaseFood.getFoodBySeller(sellerId);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(FoodCategory category) {
        return DatabaseFood.getFoodByCategory(category);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name") String name, 
                        @RequestParam(value = "price") int price, 
                        @RequestParam(value = "category") FoodCategory category, 
                        @RequestParam(value = "sellerId") int sellerId) 
    {
        try {
            for (Food food : DatabaseFood.getFoodDatabase()) {
                if (food.getName() != name) {
                     DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId), price, category));
                     return DatabaseFood.getFoodById(DatabaseFood.getLastId());
                }
            }    
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        } catch (SellerNotFoundException e) {
            System.out.println(e);
        }
        
        return null;
    }
}