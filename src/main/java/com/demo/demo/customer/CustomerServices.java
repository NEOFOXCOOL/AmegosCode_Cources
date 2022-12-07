package com.demo.demo.customer;

import com.demo.demo.exceptionhandler.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

    private CustomerRepository customerRepository;

    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public Customer  getCustomer(Long id){
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst().orElseThrow(() -> new NotFoundException("Customer with "+id+" not found"));
    }
}
