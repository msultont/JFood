package msultont.JFood.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import msultont.JFood.*;
/**
 * SellerController
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
            //TODO: handle exception
            System.out.println(e);
        }
        return seller;
        
    }

    @RequestMapping(value = "/addSeller", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name, 
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "province") String province, 
                            @RequestParam(value = "city") String city, 
                            @RequestParam(value = "description") String description) 
    {
        Seller seller = new Seller(DatabaseSeller.getLastId()+1, name, email, phoneNumber, new Location(city, province, description));
        try {
            DatabaseSeller.addSeller(seller);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return seller;
    }
    
}