package com.example.billing.oprenFeign;


import com.example.billing.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRest {

    @GetMapping("/customers/{id}")
    Customer getCustomer(@PathVariable(name = "id") Long id);

    @GetMapping("/customers")
    List<Customer> allCustomers();
}
