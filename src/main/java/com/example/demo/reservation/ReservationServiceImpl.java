package com.example.demo.reservation;

import com.example.demo.exceptions.ReservationFoundInSameDateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import static com.example.demo.reservation.ReservationCreationValidator.*;
import static com.example.demo.reservation.ReservationCreationValidator.ResultValidation.SUCCESS;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepo reservationRepo;
    @Override
    public Reservation create(Reservation reservation) {
        List<Reservation> reservations = reservationRepo
                .findByChambreId( reservation.getChambre().getId() )
                .stream().filter(res ->  !res.getEstTreminee() )
                .collect(Collectors.toList());

        ResultValidation validation = isFieldsEmpty()
                .and(isValidDate())
                .apply(reservation);

        List<Reservation> listReservations = new ArrayList<>();

        if (validation.equals(SUCCESS)){

             listReservations = reservations.stream().filter(
                     res -> !isTheSameDate.test(reservation, res)
                    && !isTheFirstContainTheSecond.test(reservation, res)
                    && !isTheSecondContainTheFirst.test(reservation, res)
                    && !isDateDebutIn.test(reservation, res)
                    && !isDateFinIn.test(reservation, res)
                    ).collect(Collectors.toList());


        }

        if (listReservations.size() == 0) return reservationRepo.save(reservation);
        throw new ReservationFoundInSameDateException("cette Chambre est deja reservee dans la date que vous avez choisi." +
                "\nPriere de changer la date ou la chambre.");

    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        reservation.setId(id);
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation delete(Reservation reservation) {
         reservationRepo.delete(reservation);
         return reservation;
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepo.findById(id).stream().findFirst().orElse(null);
    }

    @Override
    public Reservation getCurrentByClient(Long id) {
        List<Reservation> reservations = reservationRepo.findByClientId(id);
        return reservations.get(reservations.size());
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepo.findAll();
    }

    @Override
    public List<Reservation> getNotPayed() {
        return reservationRepo.findByEstPayeeIsFalse();
    }

    @Override
    public List<Reservation> getByChambre( Long id) {
        return reservationRepo.findByChambreId(id);
    }

    @Override
    public List<Reservation> getAllByClient(Long id) {
        return reservationRepo.findByClientId(id);
    }

    @Override
    public List<Reservation> getCurrentReservations() {
        List<Reservation> reservations = reservationRepo.findAll();
        return reservations.stream()
                .filter(reservation -> !reservation.getEstTreminee())
                .collect(Collectors.toList());
    }

    private final BiPredicate<Reservation,Reservation> isTheSameDate =
            (newReservation,  oldReservation) ->
                    newReservation.getDateDebutReservation() == oldReservation.getDateDebutReservation()
                    && newReservation.getDateFinReservation() == oldReservation.getDateFinReservation();

    private final BiPredicate<Reservation,Reservation> isTheSecondContainTheFirst =
            (newReservation,  oldReservation) ->
                    newReservation.getDateDebutReservation()
                            .isBefore(oldReservation.getDateDebutReservation() )
                    && newReservation.getDateFinReservation().isAfter(oldReservation.getDateFinReservation())  ;

    private final BiPredicate<Reservation, Reservation> isTheFirstContainTheSecond =
            (newReservation,  oldReservation) ->
                    newReservation.getDateDebutReservation().isAfter(oldReservation.getDateDebutReservation() )
                    && newReservation.getDateFinReservation().isBefore(oldReservation.getDateFinReservation())  ;

    private final BiPredicate<Reservation, Reservation> isDateDebutIn =
            (newReservation,  oldReservation) ->
                    newReservation.getDateDebutReservation().isAfter(oldReservation.getDateDebutReservation() )
                    && newReservation.getDateDebutReservation().isBefore(oldReservation.getDateFinReservation())  ;

    private final BiPredicate<Reservation, Reservation> isDateFinIn =
            (newReservation,  oldReservation) ->
                    newReservation.getDateFinReservation().isAfter(oldReservation.getDateDebutReservation() )
                    && newReservation.getDateFinReservation().isBefore(oldReservation.getDateFinReservation())  ;
}
