package msultont.JFood.controller;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import msultont.JFood.*;

/**
 * PromoController
 */
@RequestMapping("/promo")
@RestController
public class PromoController {
    @RequestMapping("")
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping("/{code}")
    public Promo getPromoByCode(@RequestParam(value = "code") String code) {
        for (Promo promo : getAllPromo()) {
            if (promo.getCode() == code) {
                return promo;
            }
        }
        return null;
    }

    @RequestMapping("")
    public Promo addPromo(@RequestParam(value = "code") String code, 
                          @RequestParam(value = "discount") int discount, 
                          @RequestParam(value = "minPrice") int minPrice, 
                          @RequestParam(value = "active") boolean active) 
    {
        for (Promo promo : getAllPromo()) {
            try {
                if (promo.getCode() != code) {
                    DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, code, discount, minPrice, active));
                    return DatabasePromo.getPromoById(DatabasePromo.getLastId());
                }    
            } catch (PromoNotFoundException e) {
                //TODO: handle exception
                System.out.println(e);
            } catch (PromoCodeAlreadyExistsException e) {
                System.out.println(e);
            }
            
        }
        return null;
    }
    
}