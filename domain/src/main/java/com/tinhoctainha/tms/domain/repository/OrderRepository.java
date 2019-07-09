package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
