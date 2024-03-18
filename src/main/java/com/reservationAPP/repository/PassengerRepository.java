package com.reservationAPP.repository;

import com.reservationAPP.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository <Passenger,Long> {

}
