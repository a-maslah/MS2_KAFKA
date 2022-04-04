package com.example.billing;

import com.example.billing.entities.Billing;
import com.example.billing.repository.BillingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableFeignClients
@EnableKafka
public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillingRepository billingRepository) {
        return args -> {
            billingRepository.save(new Billing(null,1000.0,1L));
            billingRepository.save(new Billing(null,2000.0,2L));
            billingRepository.save(new Billing(null,9000.0,3L));
            billingRepository.findAll().forEach(c-> System.out.println(c));
        };
    }
    }

