package com.reservationAPP.repository;

import com.reservationAPP.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository <Route, Long> {

    Route findByBusId (Long busId);


    List <Route> findByFromLocationAndToLocationAndFromDate (String fromLocation, String toLocation, String fromDate);

}
