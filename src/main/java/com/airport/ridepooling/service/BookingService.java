package com.airport.ridepooling.service;

import com.airport.ridepooling.model.BookingRequest;
import com.airport.ridepooling.repository.BookingRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 6. THE BOOKING SERVICE
 * 
 * This class coordinates the lifecycle of a ride request.
 */

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRequestRepository bookingRequestRepository;

    public BookingRequest createBooking(BookingRequest request) {
        request.setRequestTime(LocalDateTime.now());
        request.setStatus(BookingRequest.BookingStatus.PENDING);
        return bookingRequestRepository.save(request);
    }

    
    //Retrieves all passengers waiting for a cab.
    public List<BookingRequest> getPendingBookings() {
        return bookingRequestRepository.findByStatus(BookingRequest.BookingStatus.PENDING);
    }
}
