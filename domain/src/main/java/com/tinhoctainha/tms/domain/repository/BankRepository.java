package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
