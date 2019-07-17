package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
}
