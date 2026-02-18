package com.airport.ridepooling.controller;

import com.airport.ridepooling.dto.BookingCreateRequest;
import com.airport.ridepooling.dto.BookingResponse;
import com.airport.ridepooling.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@Tag(name = "Passenger Bookings", description = "Endpoints for passengers to request, track, and cancel rides")
public class BookingController {

    private final BookingService bookingService;

    // When a passenger submits their ride request.
    @PostMapping
    @Operation(summary = "Create a new Booking", description = "Submits a ride request with specific pickup/destination and capacity requirements")
    public BookingResponse createBooking(@RequestBody BookingCreateRequest request) {
        return bookingService.createBooking(request);
    }

    // Shows all passengers who are waiting for a cab.
    @GetMapping("/pending")
    @Operation(summary = "List Pending Bookings", description = "Retrieves all passengers who are currently waiting for a cab assignment")
    public List<BookingResponse> getPendingBookings() {
        return bookingService.getPendingBookings();
    }

    // Allows a user to cancel their booking.
    @DeleteMapping("/{id}/cancel")
    @Operation(summary = "Cancel a Ride", description = "Cancels a booking and automatically restores seats/luggage to the assigned cab if applicable")
    public BookingResponse cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }
}
