package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.RomoocInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomoocInsertRepository extends JpaRepository<RomoocInsert, Long> {
}
