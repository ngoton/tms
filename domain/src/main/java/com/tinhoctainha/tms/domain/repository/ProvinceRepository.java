package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
