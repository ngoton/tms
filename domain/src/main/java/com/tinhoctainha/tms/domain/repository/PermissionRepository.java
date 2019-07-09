package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
