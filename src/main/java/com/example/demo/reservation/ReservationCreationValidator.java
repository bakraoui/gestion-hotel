package com.example.demo.reservation;

import static com.example.demo.reservation.ReservationCreationValidator.ResultValidation;
import static com.example.demo.reservation.ReservationCreationValidator.ResultValidation.*;

import java.util.function.Function;

public interface ReservationCreationValidator extends Function<Reservation, ResultValidation> {

    static ReservationCreationValidator isFieldsEmpty() {
        return reservation -> reservation.getClient().getId() == null
                || reservation.getChambre().getId() == null
                || reservation.getDateDebutReservation() == null
                || reservation.getDateFinReservation() == null ? TOUS_LES_CHAMPS_SONT_OBLIGATOIRE : SUCCESS;
    }

    static ReservationCreationValidator isValidDate(){
        return reservation ->
                reservation.getDateDebutReservation().isAfter(reservation.getDateFinReservation()) ?
                        La_DATE_DEBUT_DOIT_ETRE_AVANT_LA_DATE_DE_FIN : SUCCESS;
    }



    default ReservationCreationValidator and (ReservationCreationValidator other){
        return reservation -> {
            ResultValidation resultValidation = this.apply(reservation);

            return resultValidation.equals(SUCCESS) ? other.apply(reservation) : resultValidation;
        };
    }


    enum ResultValidation{
        SUCCESS,
        TOUS_LES_CHAMPS_SONT_OBLIGATOIRE,
        CETTE_CHAMBRE_DEJA_RESERVEE_PRIERE_DE_CHANGER_LA_DATE_DE_RESERVATION,
        La_DATE_DEBUT_DOIT_ETRE_AVANT_LA_DATE_DE_FIN
    }


}
