package com.reservationAPP.service;

import com.reservationAPP.entity.Bus;
import com.reservationAPP.entity.Route;
import com.reservationAPP.entity.SubRoute;
import com.reservationAPP.payload.BusDto;
import com.reservationAPP.payload.SubRouteDto;
import com.reservationAPP.repository.BusRepository;
import com.reservationAPP.repository.RouteRepository;
import com.reservationAPP.repository.SubRouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    @Autowired
    private BusRepository busRepository;

    @Transactional
    public Bus addBus(BusDto busDto) {

//        Route route = new Route();
//        route.setFromLocation(busDto.getRoute().getFromLocation());
//        route.setToLocation(busDto.getRoute().getToLocation());
//        route.setFromDate(busDto.getRoute().getFromDate());
//        route.setToDate(busDto.getRoute().getToDate());
//        route.setTotalDuration(busDto.getRoute().getTotalDuration());
//        route.setFromTime(busDto.getRoute().getFromTime());
//        route.setToTime(busDto.getRoute().getToTime());

        //Save Route Entity
       // Route savedRoute = routeRepository.save(route);

        //create Bus Entity
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        //Associate bus with route
        //bus.setRoute(route);

        //save bus and route entity
        Bus savedBus = busRepository.save(bus);
        return savedBus;

//        Route routeUpdate = routeRepository.findById(savedRoute.getId()).get();
//        routeUpdate.setBus(savedBus);
//        routeRepository.save(routeUpdate);

        //if there are any sub-route create and save them

//        if (busDto.getSubRoutes() != null && !busDto.getSubRoutes().isEmpty()) {
//
//            for (SubRouteDto subRouteDto : busDto.getSubRoutes()) {
//
//                SubRoute subRoute = new SubRoute();
//                subRoute.setFromLocation(subRouteDto.getFromLocation());
//                subRoute.setToLocation(subRouteDto.getToLocation());
//                subRoute.setFromDate(subRouteDto.getFromDate());
//                subRoute.setToDate(subRouteDto.getToDate());
//                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
//                subRoute.setFromTime(subRouteDto.getFromTime());
//                subRoute.setToTime(subRouteDto.getToTime());
//
//                //Associate subRoute with route
//                subRoute.setRoute(route);
//
//                //Save SubRoute Entity
//                subRouteRepository.save(subRoute);
            }
        }




