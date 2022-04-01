package com.example.customer;

import com.example.customer.entities.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "amine", "zozozo"));
            customerRepository.save(new Customer(null, "soso", "zazazaz"));
            customerRepository.save(new Customer(null, "yasser", "fdghjfghjk"));
            customerRepository.findAll().forEach(c-> System.out.println(c));
        };
    }
}
