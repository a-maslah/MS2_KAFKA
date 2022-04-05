package com.example.billing.services;

import com.example.billing.entities.Customer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class BillingService {


    @Bean
    public Consumer<Customer> getCustomer(){
        return (input)->{
            System.out.println(input.toString());
        };
    }
    @Bean
    public Consumer<Long> getIdCustomer(){
        return (input)->{
            System.out.println(input);
        };
    }

}
