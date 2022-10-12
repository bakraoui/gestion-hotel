package com.example.demo.reclamation;

import java.util.function.Function;
import static com.example.demo.reclamation.ReclamationCreatorValidator.*;
import static com.example.demo.reclamation.ReclamationCreatorValidator.Validation.*;

public interface ReclamationCreatorValidator extends Function<Reclamation, Validation> {

    static ReclamationCreatorValidator isClientExit() {
        return reclamation -> {
            Long idClient = reclamation.getClient().getId();
            return idClient == null ? ID_CLIENT_EST_NULL : SUCCESS;
        };
    }

    static ReclamationCreatorValidator isDescriptionEmpty () {
        return reclamation -> {
            String description = reclamation.getDescription();

            return description.isEmpty() ? DESCRIPTION_EST_OBLIGATOIRE : SUCCESS;
        };
    }

    static ReclamationCreatorValidator isReservationExist() {
        return reclamation -> {
            Long idReservation = reclamation.getReservation().getId();

            return idReservation == null ? ID_RESERVATION_EST_NULL : SUCCESS;
        };
    }


    enum Validation{
        DESCRIPTION_EST_OBLIGATOIRE, ID_CLIENT_EST_NULL, ID_RESERVATION_EST_NULL, SUCCESS
    }

    default ReclamationCreatorValidator and (ReclamationCreatorValidator other) {
        return reclamation -> {
            Validation result = other.apply(reclamation);
            return result.equals(SUCCESS) ? other.apply(reclamation) : result;
        };
    }
}
