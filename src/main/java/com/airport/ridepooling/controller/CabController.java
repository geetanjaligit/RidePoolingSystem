package com.airport.ridepooling.controller;

import com.airport.ridepooling.dto.CabRequest;
import com.airport.ridepooling.dto.CabResponse;
import com.airport.ridepooling.service.CabService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabs")
@RequiredArgsConstructor
public class CabController {

    private final CabService cabService;

    // Used to register a new cab.
    @PostMapping
    public CabResponse registerCab(@RequestBody CabRequest cabRequest) {
        return cabService.registerCab(cabRequest);
    }

    // Used to list all cabs currently in our system.
    @GetMapping
    public List<CabResponse> getAllCabs() {
        return cabService.getAllCabs();
    }

    // Used to find cabs that are not yet full.
    @GetMapping("/available")
    public List<CabResponse> getAvailableCabs() {
        return cabService.getAvailableCabs();
    }
}
