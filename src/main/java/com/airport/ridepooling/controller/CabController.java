package com.airport.ridepooling.controller;

import com.airport.ridepooling.dto.CabRequest;
import com.airport.ridepooling.dto.CabResponse;
import com.airport.ridepooling.service.CabService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabs")
@RequiredArgsConstructor
@Tag(name = "Cab Management", description = "Endpoints for registering and tracking the airport taxi fleet")
public class CabController {

    private final CabService cabService;

    // Used to register a new cab.
    @PostMapping
    @Operation(summary = "Register a new Cab", description = "Adds a new taxi to the airport fleet system")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest) {
        return cabService.registerCab(cabRequest);
    }

    // Used to list all cabs currently in our system.
    @GetMapping
    @Operation(summary = "Get all Cabs", description = "Retrieves the full list of all registered taxis")
    public List<CabResponse> getAllCabs() {
        return cabService.getAllCabs();
    }

    // Used to find cabs that are not yet full.
    @GetMapping("/available")
    @Operation(summary = "Get available Cabs", description = "Retrieves only the cabs that have enough remaining seats/luggage for pooling")
    public List<CabResponse> getAvailableCabs() {
        return cabService.getAvailableCabs();
    }
}
