package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Oil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OilRepository extends JpaRepository<Oil, Long> {
}
