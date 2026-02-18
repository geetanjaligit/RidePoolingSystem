package com.airport.ridepooling.controller;

import com.airport.ridepooling.service.PoolingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pooling")
@RequiredArgsConstructor
@Tag(name = "Matching Engine", description = "Endpoints to manually trigger the ride-pooling logic")
public class PoolingController {

    private final PoolingService poolingService;

    @PostMapping("/run")
    @Operation(summary = "Run Pooling Algorithm", description = "Executes the engine to pair pending passengers with available cabs")
    public ResponseEntity<String> runPooling() {
        poolingService.processPendingBookings();
        return ResponseEntity.ok("Pooling algorithm executed successfully!");
    }
}
