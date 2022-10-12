package com.example.demo.reclamation;

import com.example.demo.clients.Client;
import com.example.demo.intervention.DemandeIntervention;
import com.example.demo.reservation.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String description;
    private Boolean estTraitee;

    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @ManyToOne
    private Client client;

    @ManyToOne
    private Reservation reservation;


}
