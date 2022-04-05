package com.example.customer.web;

import com.example.customer.entities.Billing;
import com.example.customer.entities.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.services.ServiceCustomer;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;
    private KafkaTemplate<Integer,Customer> kafkaTemplate;
    private StreamBridge streamBridge ;
    private ServiceCustomer serviceCustomer ;

    public CustomerController(CustomerRepository customerRepository, KafkaTemplate<Integer, Customer> kafkaTemplate, StreamBridge streamBridge, ServiceCustomer serviceCustomer) {
        this.customerRepository = customerRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.streamBridge = streamBridge;
        this.serviceCustomer = serviceCustomer;
    }
    private String topic="bankStore";
    private String requestTopic = "request";
    private String responseTopic = "response";

    @GetMapping("/billings/{id}")
    public void getBillings(@PathVariable Long id){

        streamBridge.send(topic,new Long(id));

    }

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name) {
        streamBridge.send(topic, new
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
