package com.example.billing.web;

import com.example.billing.entities.Billing;
import com.example.billing.entities.Customer;
import com.example.billing.oprenFeign.CustomerRest;
import com.example.billing.repository.BillingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillingController {
    private BillingRepository billingRepository;

    private CustomerRest customerRest;
    public BillingController(BillingRepository customerRepository, CustomerRest customerRest) {
        this.billingRepository = customerRepository;
        this.customerRest = customerRest;
    }


    @GetMapping(path = "/billings")
    public List<Billing> getAllBilling(){

        List<Billing> billings =  billingRepository.findAll();
        for(Billing b:billings){
            Customer customer = customerRest.getCustomer(b.getCustomerId());
            b.setCustomer(customer);
        }
        return billings;
    }

    @GetMapping(path = "/billing/{id}")
    public Billing getBillingById(@PathVariable Long id){
        Billing billing  =  billingRepository.findById(id).get();
        Customer customer = customerRest.getCustomer(billing.getCustomerId());
        billing.setCustomer(customer);
        return billing;
    }

    @PostMapping(path = "/billing")
    public Billing saveBilling(@RequestBody Billing customer){
        return billingRepository.save(customer);
    }
}
