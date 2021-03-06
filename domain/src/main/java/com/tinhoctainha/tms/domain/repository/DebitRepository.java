package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Debit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends JpaRepository<Debit, Long> {
}
