package com.airport.ridepooling.dto;

import lombok.*;
//This is the "Input Form" for registering a new cab.

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CabRequest {
    private String licensePlate;
    private String model;
    private Integer totalSeats;
    private Integer maxLuggage;
}
