package com.airport.ridepooling.controller;

import com.airport.ridepooling.dto.BookingCreateRequest;
import com.airport.ridepooling.dto.BookingResponse;
import com.airport.ridepooling.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // When a passenger submits their ride request.
    @PostMapping
    public BookingResponse createBooking(@RequestBody BookingCreateRequest request) {
        return bookingService.createBooking(request);
    }

    // Shows all passengers who are waiting for a cab.
    @GetMapping("/pending")
    public List<BookingResponse> getPendingBookings() {
        return bookingService.getPendingBookings();
    }
}
