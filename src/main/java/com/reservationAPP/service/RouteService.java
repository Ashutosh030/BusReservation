package com.reservationAPP.service;

import com.reservationAPP.entity.Bus;
import com.reservationAPP.entity.Route;
import com.reservationAPP.exception.ResourceNotFound;
import com.reservationAPP.repository.BusRepository;
import com.reservationAPP.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusRepository busRepository;

    public Route createRoute (Long busId, Route route){

        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not added..!!")
        );
        Route r = routeRepository.findByBusId(route.getBusId());

        if (r!=null){
            throw new ResourceNotFound("Route was already added");
        }

        if (r==null) {

            routeRepository.save(route);
            return route;
        }
        //if not return null-
        return null;
    }
}
