package com.airport.ridepooling.repository;

import com.airport.ridepooling.model.BookingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRequestRepository extends JpaRepository<BookingRequest, Long> {

    List<BookingRequest> findByStatus(BookingRequest.BookingStatus status);
}
