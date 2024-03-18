package com.reservationAPP.payload;


import lombok.Data;

@Data
public class SearchListOfBusDto {

    private Long busID; // Primary key

    private String busNumber;
    private String busType;
    private double price;
    private int availableSeats;
    private int totalSeats;


    private Long routeId;

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
}
