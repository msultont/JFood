package msultont.JFood.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import msultont.JFood.*;
/**
 * This is all Seller's API for requesting the data into backend system.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@RequestMapping("/seller")
@RestController
public class SellerController {
    @RequestMapping("")
    public String indexPage() {
        return "Hello, you are in the seller page";
    }

    @RequestMapping("/listSeller")
    public ArrayList<Seller> getAllSeller() {
        return DatabaseSeller.getSellerDatabase();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@PathVariable int id) {
        Seller seller = null;
        try {
            seller = DatabaseSeller.getSellerById(id); 
        } catch (SellerNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return seller;
        
    }

    @RequestMapping(value = "/addSeller", method = RequestMethod.POST)
    public boolean addSeller(@RequestParam(value = "name") String name, 
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "city") String city) 
    {
        Seller seller = null;
        try {
            seller = new Seller(DatabaseSeller.getLastId()+1, name, email, phoneNumber, DatabaseLocation.getLocationByCity(city));
            
        } catch (LocationNotFoundException e) {
            System.err.println(e.getMessage());
        }

        if (seller != null) {
            DatabaseSeller.addSeller(seller);
            return true;
        }

        return false;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean removeSeller(@RequestParam(value = "seller_id") int seller_id) {
        boolean sql_result = false;
        try {
            sql_result = DatabaseSeller.removeSeller(seller_id);
        } catch (SellerNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return sql_result;

    }
    
}