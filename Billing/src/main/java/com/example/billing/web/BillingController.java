package com.example.billing.web;

import com.example.billing.entities.Billing;
import com.example.billing.repository.BillingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillingController {
    private BillingRepository billingRepository;

    public BillingController(BillingRepository customerRepository) {
        this.billingRepository = customerRepository;
    }

    @GetMapping(path = "/billings")
    public List<Billing> getAllBilling(){
        return billingRepository.findAll();
    }

    @GetMapping(path = "/billing/{id}")
    public Billing getBillingById(@PathVariable Long id){
        return billingRepository.findById(id).get();
    }

    @PostMapping(path = "/billing")
    public Billing saveBilling(@RequestBody Billing customer){
        return billingRepository.save(customer);
    }
}
