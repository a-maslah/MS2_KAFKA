package com.example.billing.entities;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Billing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private Long customerId;

    @Transient private Customer customer;

    public Billing(Long id, double amount, Long customerId) {
        this.id = id;
        this.amount = amount;
        this.customerId = customerId;
    }
}

