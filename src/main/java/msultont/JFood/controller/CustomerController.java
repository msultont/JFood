package msultont.JFood.controller;

import msultont.JFood.*;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

/**
 * This is all customer's API for requesting the data into backend system.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @RequestMapping("")
    public String indexPage() {
        return "Hello, you are in the customer page";
    }

    @RequestMapping("/")
    public ArrayList<Customer> getAllCustomer() {
        return DatabaseCustomer.getCustomerDatabase();
    }

    @RequestMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = null;
        try {
            customer = DatabaseCustomer.getCustomerById(id);
        } catch (CustomerNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return customer;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value = "email") String email, 
                                 @RequestParam(value = "password") String password) 
    {
        Customer customer = null;
        customer = DatabaseCustomer.customerLogin(email, password);

        if (customer != null) {
            System.out.println("Login Successfull");
            return customer;
        }

        System.out.println("Login Unsuccessfull");
        return customer;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestParam(value="name") String name,
                                @RequestParam(value="email") String email,
                                @RequestParam(value="password") String password)
    {
        Customer customer = null;
        if (name.equals("") || email.equals("") || password.equals(""))
            return customer;
        else {
            customer = new Customer(DatabaseCustomer.getLastId()+1, name, email, password);
            try {
                DatabaseCustomer.addCustomer(customer);
            } catch (EmailAlreadyExistsException e) {
                System.err.println(e.getMessage());
            }
        }
        return customer;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean deleteCustomer(@RequestParam(value = "customer_id") int customer_id) {
        boolean sql_result = false;
        try {
            sql_result = DatabaseCustomer.removeCustomer(customer_id);
        } catch (CustomerNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return sql_result;
    } 

    

    

}
