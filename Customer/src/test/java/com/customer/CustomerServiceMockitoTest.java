package com.customer;

import com.customer.beans.Address;
import com.customer.beans.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.customerService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CustomerServiceMockitoTest.class})
public class CustomerServiceMockitoTest {

    @Mock
    CustomerRepository customerRep;

    @InjectMocks
    customerService customerSer;


    @Test
    @Order(1)
    public void test_getCustomers(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);
        customer.add(customer1);
        customer.add(customer2);

        when(customerRep.findAll()).thenReturn(customer);
        assertEquals(2, customerSer.getCustomers().size());
    }

    @Test
    @Order(2)
    public void test_getCustomerById(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);
        customer.add(customer1);
        customer.add(customer2);
        int id=1;

        when(customerRep.findAll()).thenReturn(customer);

        assertEquals(id, customerSer.getCustomerById(id).getCustomerId());
    }

    @Test
    @Order(3)
    public void test_createCustomer(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        customer.add(customer1);

        when(customerRep.save(customer1)).thenReturn(customer1);

        assertEquals(customer1, customerSer.createCustomer(customer1));
    }

    @Test
    @Order(4)
    public void test_updateCustomer(){
        List<Customer> customer = new ArrayList<>();
        Address add1 = new Address(1,"1-69/3", "Washington St.", "Washington", "USA", 534043);
        Customer customer1 = new Customer(1,"James", "Smith", "JSmith", "2002-01-19",21, "jsmith@gmail.com","(+1) 555 1234567", add1);
        customer.add(customer1);

        when(customerRep.save(customer1)).thenReturn(customer1);

        assertEquals(customer1, customerSer.updateCustomer(customer1));
    }

    @Test
    @Order(5)
    public void test_deleteCustomer(){
        List<Customer> customer = new ArrayList<>();
        Address add2 = new Address(2,"4-82/1", "Mario St.", "Canada", "USA", 657382);
        Customer customer2 = new Customer(2,"John", "Doe", "JDoe", "2003-02-20", 20,"jdoe@gmail.com","(+1) 555 1234567", add2);

        customer.add(customer2);

        customerSer.deleteCustomer(customer2.getCustomerId());
        verify(customerRep,times(1));
    }

}

