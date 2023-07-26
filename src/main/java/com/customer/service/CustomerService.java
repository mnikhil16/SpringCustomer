package com.customer.service;

import com.customer.controller.AddResponse;
import com.customer.repository.CustomerRepository;
import com.customer.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRep;

    public List<Customer> getCustomers(){
       return customerRep.findAll();
    }


    public Customer getCustomerById(int Id){
        List<Customer> customers = customerRep.findAll();
        Customer customer = null;
        for(Customer c: customers){
            if(c.getCustomerId() == Id){
                customer = c;
            }
        }
        return customer;
    }

    public Customer createCustomer(Customer customer){
        return customerRep.save(customer);
    }

    public int getMaxId(){

        return customerRep.findAll().size()+1;
    }

    public Customer updateCustomer(Customer customer){
        return customerRep.save(customer);
    }


    public AddResponse deleteCustomer(int Id){
            customerRep.deleteById(Id);
            AddResponse res = new AddResponse();
            res.setMsg("Customer deleted");
            res.setId(Id);
            return res;
    }
}
