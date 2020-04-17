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
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) {
        return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id, 
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

    @RequestMapping(value = "/deleteInvoice", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@RequestParam(value = "id") int id) {
        try {
            DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return true;
    }

    @RequestMapping(value = "/addFood/{customerId}", method = RequestMethod.PUT)
    public Invoice addFoodPerInvoiceByCustomerId(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList, 
                                                 @PathVariable int customerId) {
        ArrayList<Food> newFood = new ArrayList<>();
        try {
            for (int counter : foodIdList) {
                newFood.add(DatabaseFood.getFoodById(counter));
            }
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(customerId)) {
            if (invoice.getPaymentType().equals(PaymentType.Cash)) {
                for (Food food : newFood) {
                    invoice.setFoods(food);
                    invoice.setTotalPrice();
                }
                return invoice;
            }
        }
        return null;
    }

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foodIdList") ArrayList<Integer> foodIdList, 
                                  @RequestParam(value = "customerId") int customerId, 
                                  @RequestParam(value = "deliveryFee") int deliveryFee) 
    {
        ArrayList<Food> newFood = new ArrayList<>();
        CashInvoice cashInvoice = null;
        try {
            for (int counter : foodIdList) {
                newFood.add(DatabaseFood.getFoodById(counter));
            }
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }

        try {
            cashInvoice = new CashInvoice(DatabaseInvoice.getLastId()+1, newFood, DatabaseCustomer.getCustomerById(customerId), deliveryFee);
            cashInvoice.setTotalPrice();
        } catch (CustomerNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        try {
            DatabaseInvoice.addInvoice(cashInvoice);
            return cashInvoice;
        } catch (OngoingInvoiceAlreadyExistsException e) {
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
        CashlessInvoice cashlessInvoice = null;
        try {
            for (int counter : foodIdList) {
                newFood.add(DatabaseFood.getFoodById(counter));
            }
        } catch (FoodNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        try {
            cashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, newFood, DatabaseCustomer.getCustomerById(customerId), DatabasePromo.getPromoByCode(promoCode));
            cashlessInvoice.setTotalPrice();
            
        } catch (CustomerNotFoundException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        try {
            DatabaseInvoice.addInvoice(cashlessInvoice);
            return cashlessInvoice;
        } catch (OngoingInvoiceAlreadyExistsException e) {
            //TODO: handle exception
            System.out.println(e);
        }
        return null;
    }
}