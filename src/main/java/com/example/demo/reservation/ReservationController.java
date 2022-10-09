package com.example.demo.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("")
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation){
        return new ResponseEntity<>(
                reservationService.create(reservation),
                HttpStatus.CREATED
                );
    }

    @PutMapping("")
    public ResponseEntity<Reservation> update(@RequestBody Reservation reservation){
        return new ResponseEntity<>(
                reservationService.update(reservation),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("")
    public ResponseEntity<Reservation> delete(@RequestBody Reservation reservation){
        reservationService.delete(reservation);
        return new ResponseEntity<>(
                reservation,
                HttpStatus.CREATED
        );
    }

    @GetMapping("")
    public ResponseEntity<List<Reservation>> getAll(){
        return new ResponseEntity<>(
                reservationService.getAll(),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable Long id){
        return new ResponseEntity<>(
                reservationService.getById(id),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/client/{id}/current")
    public ResponseEntity<Reservation> getCurrentReservationByClient(@PathVariable Long id){
        return new ResponseEntity<>(
                reservationService.getCurrentByClient(id),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Reservation>> getAllByClient(@PathVariable Long id){
        return new ResponseEntity<>(
                reservationService.getAllByClient(id),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/not-payed")
    public ResponseEntity<List<Reservation>> getNotPayed(){
        return new ResponseEntity<>(
                reservationService.getNotPayed(),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/chamber/{id}")
    public ResponseEntity<List<Reservation>> getByChamber(@PathVariable Long id){
        return new ResponseEntity<>(
                reservationService.getByChambre(id),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/current")
    public ResponseEntity<List<Reservation>> getAllCurrent(){
        return new ResponseEntity<>(
                reservationService.getCurrentReservations(),
                HttpStatus.FOUND
        );
    }


}
