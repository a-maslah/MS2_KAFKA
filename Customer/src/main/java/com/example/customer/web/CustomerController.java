package com.example.customer.web;

import com.example.customer.entities.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;
    private KafkaTemplate<Integer,Customer> kafkaTemplate;


    public CustomerController(CustomerRepository customerRepository, KafkaTemplate<Integer, Customer> kafkaTemplate) {
        this.customerRepository = customerRepository;
        this.kafkaTemplate = kafkaTemplate;
    }
    private String topic="topicamine";

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name) {
        kafkaTemplate.send(topic, new
                Customer(null,name,"casa"));
        return "Message Published";
    }
    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping(path = "customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping(path = "customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
