package com.reservationAPP.repository;

import com.reservationAPP.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository <UserRegistration, Long> {


}
