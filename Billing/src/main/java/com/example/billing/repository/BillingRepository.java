package com.example.billing.repository;

import com.example.billing.entities.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {

    List<Billing> findByCustomerId(Long id);
}
