package com.customer.controller;

import com.customer.beans.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

        @Autowired
        CustomerService service;

        @GetMapping("/Customers")
        public List<Customer> getAllCustomers(){

            return service.getCustomers();
        }

        @GetMapping("/getCustomerById/{customerId}")
        public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "customerId") int customerId) {

            try {
                Customer customer = service.getCustomerById(customerId);
                return new ResponseEntity<Customer>(customer, HttpStatus.OK);
            }
            catch(Exception e){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("/createCustomer")
        public Customer createCustomer(@RequestBody Customer customer){

            return service.createCustomer(customer);
        }

        @PutMapping("/updateCustomer")
        public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
                try{
                    Customer updatedCustomer = service.updateCustomer(customer);
                    return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
                }
                catch(Exception e){
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }

        }

        @DeleteMapping("/deleteCustomerById/{customerId}")
        public AddResponse deleteCustomer(@PathVariable(value = "customerId") int customerId){
            return service.deleteCustomer(customerId);
        }
}
