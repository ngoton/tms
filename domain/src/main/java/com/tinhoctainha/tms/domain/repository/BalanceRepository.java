package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
