package com.demo.demo.customer;

import com.demo.demo.exceptionhandler.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/app/v2/customers")
@RestController
public class CutomerControllerV2 {
    private CustomerServices customerServices;

    public CutomerControllerV2(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @GetMapping
    public List<Customer> getCustomers(){
       return customerServices.getCustomers();
    }

    @GetMapping(path = "{customerid}")
    Customer getCustomer(@PathVariable("customerid") Long id){
        return customerServices.getCustomer(id);
    }

    @GetMapping(path = "{customerid}/exception")
    Customer getCustomerException(@PathVariable("customerid") Long id){
        throw new ApiRequestException("ApiRequestException for id : "+id);
    }

    @PostMapping(path = "/newcustomer")
    public void newCustomer(@Valid @RequestBody Customer customer){
        System.out.println("add new customer...");
        System.out.println(customer);
    }
    @PutMapping(path = "/updatecustomer")
    public void updateCustomer(@RequestBody  Customer customer){
        System.out.println("update customer ...");
    }

    @DeleteMapping(path = "{customerid}")
    public void deletecustomer(@PathVariable("customerid") Long id ){
        System.out.println("delete customer ...");
    }
}
