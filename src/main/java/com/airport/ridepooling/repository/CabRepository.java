package com.airport.ridepooling.repository;

import com.airport.ridepooling.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {
    List<Cab> findByStatus(Cab.CabStatus status);
}
