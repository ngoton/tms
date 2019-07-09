package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
