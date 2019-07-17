package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
