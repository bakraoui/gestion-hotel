package com.example.demo.reservation;

import com.example.demo.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo  extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClientId(Long id);
    List<Reservation> findByEstPayeeIsFalse();
    List<Reservation> findByChambreId(Long id);


}
