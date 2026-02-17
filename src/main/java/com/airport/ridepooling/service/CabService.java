package com.airport.ridepooling.service;

import com.airport.ridepooling.model.Cab;
import com.airport.ridepooling.repository.CabRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 5. THE SERVICE LAYER (The Brain)
 * 
 * Why do we need this?
 * The Repository is just for "Storage". But what if we need to check something
 * before saving?
 * What if we need to calculate a price or find the best cab? That logic goes
 * here.
 */

@Service // Tells Spring: "This is where the business rules live."
@RequiredArgsConstructor // Lombok creates a constructor for 'cabRepository' automatically.
public class CabService {

    // We "inject" the Repository so we can talk to the database.
    private final CabRepository cabRepository;

    /**
     * Logic for registering a new cab.
     * We ensure that every new cab starts as 'AVAILABLE'.
     */
    public Cab registerCab(Cab cab) {
        cab.setStatus(Cab.CabStatus.AVAILABLE);
        return cabRepository.save(cab);
    }

    /**
     * Simple request to get all cabs from the database.
     */
    public List<Cab> getAllCabs() {
        return cabRepository.findAll();
    }

    /**
     * Finds cabs that are not yet full.
     */
    public List<Cab> getAvailableCabs() {
        return cabRepository.findByStatus(Cab.CabStatus.AVAILABLE);
    }
}
