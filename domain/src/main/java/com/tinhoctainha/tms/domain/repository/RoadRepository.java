package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Road;
import com.tinhoctainha.tms.domain.model.RoadId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadRepository extends JpaRepository<Road, RoadId> {
}
