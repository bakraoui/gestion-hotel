package com.example.demo.reservation;


import java.util.List;

public interface ReservationService {

    Reservation create(Reservation reservation);
    Reservation delete(Reservation reservation);
    Reservation update(Long id, Reservation reservation);
    Reservation getById(Long id);
    Reservation getCurrentByClient(Long id);
    List<Reservation> getAll();
    List<Reservation> getNotPayed();
    List<Reservation> getByChambre(Long id);
    List<Reservation> getAllByClient(Long id);
    List<Reservation> getCurrentReservations();

}
