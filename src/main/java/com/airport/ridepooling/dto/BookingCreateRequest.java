package com.airport.ridepooling.dto;

import lombok.*;

//What a passenger sends when they want a ride.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingCreateRequest {
    private String passengerName;
    private Double pickupLat;
    private Double pickupLng;
    private Double destLat;
    private Double destLng;
    private Integer seatsRequired;
    private Integer luggageQuantity;
}
