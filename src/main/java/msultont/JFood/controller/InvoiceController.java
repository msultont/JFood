package msultont.JFood.controller;

import msultont.JFood.*;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return invoice;

    }

    @RequestMapping("/customer/{customerId}")
    public ArrayList<Invoice> getInvoiceByCustomer(int customerId) {
        return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value = "id") int id, 
                                       @RequestParam(value = "status") InvoiceStatus status) 
    {
        for (Invoice invoice : getAllInvoice()) {
            if (invoice.getId() == id) {
                invoice.setInvoiceStatus(status);
                return invoice;
            }
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@RequestParam(value = "id") int id) {
        try {
            for (Invoice invoice : getAllInvoice()) {
                if (invoice.getId() == id) {
                    DatabaseInvoice.removeInvoice(id);
                }
            }    
        } catch (InvoiceNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return true;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList, 
                                  @RequestParam(value = "customerId") int customerId, 
                                  @RequestParam(value = "deliveryFee") int deliveryFee) 
    {
        ArrayList<Food> newFood = new ArrayList<>();
        try {
            newFood.add(DatabaseFood.getFoodById(foodIdList.get(0)));
            newFood.add(DatabaseFood.getFoodById(foodIdList.get(1)));
            newFood.add(DatabaseFood.getFoodById(foodIdList.get(2)));
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        try {
            CashInvoice cashInvoice = new CashInvoice(DatabaseInvoice.getLastId()+1, newFood, DatabaseCustomer.getCustomerById(customerId), deliveryFee);
            cashInvoice.setTotalPrice();
            try {
                DatabaseInvoice.addInvoice(cashInvoice);
            } catch (OngoingInvoiceAlreadyExistsException e) {
                //TODO: handle exception
                System.out.println(e);
            }
            return cashInvoice;
        } catch (CustomerNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice (@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList, 
                                       @RequestParam(value = "customerId" )int customerId, 
                                       @RequestParam(value = "promoCode") String promoCode) 
    {
        ArrayList<Food> newFood = new ArrayList<>();
        try {
            newFood.add(DatabaseFood.getFoodById(foodIdList.get(0)));
            newFood.add(DatabaseFood.getFoodById(foodIdList.get(1)));
            newFood.add(DatabaseFood.getFoodById(foodIdList.get(2)));
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        } 
        try {
            CashlessInvoice cashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, newFood, DatabaseCustomer.getCustomerById(customerId), DatabasePromo.getPromoByCode(promoCode));
            cashlessInvoice.setTotalPrice();
            try {
                DatabaseInvoice.addInvoice(cashlessInvoice);
            } catch (OngoingInvoiceAlreadyExistsException e) {
                //TODO: handle exception
                System.out.println(e);
            }
            return cashlessInvoice;
        } catch (CustomerNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return null;

    }
}