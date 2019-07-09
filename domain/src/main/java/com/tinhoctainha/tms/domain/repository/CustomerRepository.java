package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
