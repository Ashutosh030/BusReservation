package com.reservationAPP.controller;

import com.reservationAPP.entity.Bus;
import com.reservationAPP.entity.Route;
import com.reservationAPP.entity.SubRoute;
import com.reservationAPP.payload.BusDto;
import com.reservationAPP.payload.SearchListOfBusDto;
import com.reservationAPP.repository.BusRepository;
import com.reservationAPP.repository.RouteRepository;
import com.reservationAPP.repository.SubRouteRepository;
import com.reservationAPP.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private SubRouteRepository subRouteRepository;

    //http://localhost:8080/api/v1/bus/add

    @PostMapping("/add")
    public ResponseEntity<Bus> addBus (@RequestBody BusDto busDto) throws ParseException {

//        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//        Date fromDate = format.parse(busDto.getFromDate());
//        Date toDate = format.parse(busDto.getToDate());

        Bus bus = busService.addBus(busDto);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }

   // http://localhost:8080/api/v1/bus?fromLocation=&toLocation=&fromDate
    @GetMapping
    public  List<SearchListOfBusDto> getAllBusses (@RequestParam String fromLocation,
                                    @RequestParam String toLocation,
                                    @RequestParam String fromDate){

        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SubRoute>  subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);

        List<SearchListOfBusDto> buses= new ArrayList<>();

        // If Route is there, it should give route only, Not Sub-Route. or else it will give sub-route.
        if (routes!=null) {

            for (Route route : routes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBusDto searchListOfBusDto = mapToSearchListOfBusDto(bus, route);
                buses.add(searchListOfBusDto);
            }
            return buses;
        }
        //For sub-route -

        if (subRoutes!=null) {

            for (SubRoute route : subRoutes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBusDto searchListOfBusDto = mapToSearchListOfBusDto(bus, route);
                buses.add(searchListOfBusDto);
            }
            return buses;
        }

        return null;                //47:00 .
    }

    SearchListOfBusDto mapToSearchListOfBusDto(Bus bus, Route route){
        SearchListOfBusDto searchListOfBusDto = new SearchListOfBusDto();
        searchListOfBusDto.setBusID(bus.getBusID());
        searchListOfBusDto.setBusNumber(bus.getBusNumber());
        searchListOfBusDto.setPrice(bus.getPrice());
        searchListOfBusDto.setBusType(bus.getBusType());
        searchListOfBusDto.setTotalSeats(bus.getTotalSeats());
        searchListOfBusDto.setAvailableSeats(bus.getAvailableSeats());

        searchListOfBusDto.setFromLocation(route.getFromLocation());
        searchListOfBusDto.setToLocation(route.getToLocation());
        searchListOfBusDto.setFromDate(route.getFromDate());
        searchListOfBusDto.setToDate(route.getToDate());
        searchListOfBusDto.setFromTime(route.getFromTime());
        searchListOfBusDto.setRouteId(route.getId());
        searchListOfBusDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusDto.setToTime(route.getToTime());

        return searchListOfBusDto;
    }

    SearchListOfBusDto mapToSearchListOfBusDto(Bus bus, SubRoute route){
        SearchListOfBusDto searchListOfBusDto = new SearchListOfBusDto();
        searchListOfBusDto.setBusID(bus.getBusID());
        searchListOfBusDto.setBusNumber(bus.getBusNumber());
        searchListOfBusDto.setPrice(bus.getPrice());
        searchListOfBusDto.setBusType(bus.getBusType());
        searchListOfBusDto.setTotalSeats(bus.getTotalSeats());
        searchListOfBusDto.setAvailableSeats(bus.getAvailableSeats());

        searchListOfBusDto.setFromLocation(route.getFromLocation());
        searchListOfBusDto.setToLocation(route.getToLocation());
        searchListOfBusDto.setFromDate(route.getFromDate());
        searchListOfBusDto.setToDate(route.getToDate());
        searchListOfBusDto.setFromTime(route.getFromTime());
        searchListOfBusDto.setRouteId(route.getId());
        searchListOfBusDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusDto.setToTime(route.getToTime());

        return searchListOfBusDto;
    }


}

