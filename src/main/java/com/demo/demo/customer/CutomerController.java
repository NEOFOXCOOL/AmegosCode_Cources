package com.demo.demo.customer;

import com.demo.demo.exceptionhandler.ApiRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(path = "/app/v1/customers")
@RestController
public class CutomerController {
    private CustomerServices customerServices;

    public CutomerController(CustomerServices customerServices) {

        this.customerServices = customerServices;
    }

    @GetMapping(value = "/all")
    public List<Customer> getCustomers(){
        return Collections.singletonList(
                new Customer(1L,"V1","123","mari@gmail.com")
        );
    }
    @GetMapping("/{customerid}")
    public Customer getCustomer(@PathVariable("customerid") Long id){

        return  customerServices.getCustomer(id);
    }

    @GetMapping("/{customerid}/exception")
    public Customer getCustomerException(@PathVariable("customerid") Long id){
        throw new ApiRequestException("ApiRequestException for" + id);
    }

    @PostMapping(path = "/newcustomer")
    public void newCustomer(@RequestBody Customer customer){
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
