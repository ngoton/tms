package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
