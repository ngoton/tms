package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
