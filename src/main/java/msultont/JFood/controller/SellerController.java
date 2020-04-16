package msultont.JFood.controller;

import java.util.ArrayList;

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
    public ArrayList<Seller> getAllSeller() {
        return DatabaseSeller.getSellerDatabase();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Seller getSellerById(@RequestParam(value = "id") int id) {
        try {
            return DatabaseSeller.getSellerById(id);    
        } catch (SellerNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return null;
        
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name, 
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "province") String province, 
                            @RequestParam(value = "city") String city, 
                            @RequestParam(value = "description") String description) 
    {
        
        for (Seller seller : DatabaseSeller.getSellerDatabase()) {
            if (seller.getName() != name) {
                DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, name, email, phoneNumber, new Location(city, province, description)));
                return seller;
            }
        }
        return null;
    }
    
}