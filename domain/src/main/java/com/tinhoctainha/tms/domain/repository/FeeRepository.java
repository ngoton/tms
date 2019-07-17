package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {
}
