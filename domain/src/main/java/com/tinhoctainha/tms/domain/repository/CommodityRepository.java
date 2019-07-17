package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Long> {
}
