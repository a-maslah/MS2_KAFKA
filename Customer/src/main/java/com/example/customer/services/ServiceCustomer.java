package com.example.customer.services;

import com.example.customer.entities.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class ServiceCustomer {
    /*
    @Bean
    Consumer<Customer> consumeCustomer(){
        return (input) ->{
            System.out.println("********************");
            System.out.println(input.toString());
            System.out.println("********************");
        };
    }

     */
    @Bean
    Consumer<List<Customer>> consumeListCustomers(){
        return (input) ->{
            System.out.println("********************");
            System.out.println(input.toString());
            System.out.println("********************");
        };
    }
    /*
    @Bean
    Supplier<Customer> supplierCustomer(){
        return ()-> new Customer(null,"abdo","sale");
    }

     */
}
