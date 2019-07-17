package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.CostList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostListRepository extends JpaRepository<CostList, Long> {
}
