package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
