package msultont.JFood.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import msultont.JFood.*;

/**
 * This is all promo's API for requesting the data into backend system.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@RequestMapping("/promo")
@RestController
public class PromoController {
    @RequestMapping("")
    public String indexPage() {
        return "Hello, you are in the promo page";
    }

    @RequestMapping(value = "/listPromo", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/code/{promoCode}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String promoCode) {
        Promo promo = null;
        try {
            promo = DatabasePromo.getPromoByCode(promoCode);
        } catch (PromoNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return promo;
    }

    @RequestMapping(value = "/addPromo", method = RequestMethod.POST)
    public boolean addPromo(@RequestParam(value = "code") String code, 
                          @RequestParam(value = "discount") int discount, 
                          @RequestParam(value = "minPrice") int minPrice, 
                          @RequestParam(value = "active") boolean active) 
    {
        Promo promo = new Promo(DatabasePromo.getLastId()+1, code, discount, minPrice, active);
        try {
            DatabasePromo.addPromo(promo);
        } catch (PromoCodeAlreadyExistsException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean removePromo(@RequestParam(value = "promo_id") int promo_id) {
        boolean sql_result = false;
        try {
            sql_result = DatabaseFood.removeFood(promo_id);
        } catch (FoodNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return sql_result;

    }
    
}