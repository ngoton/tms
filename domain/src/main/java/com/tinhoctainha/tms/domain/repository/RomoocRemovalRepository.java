package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.RomoocRemoval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomoocRemovalRepository extends JpaRepository<RomoocRemoval, Long> {
}
