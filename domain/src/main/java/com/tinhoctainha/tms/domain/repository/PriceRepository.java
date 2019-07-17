package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Price;
import com.tinhoctainha.tms.domain.model.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, PriceId> {
}
