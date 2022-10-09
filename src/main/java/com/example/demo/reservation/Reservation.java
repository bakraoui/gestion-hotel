package com.example.demo.reservation;

import com.example.demo.reclamation.Reclamation;
import com.example.demo.chambre.Chambre;
import com.example.demo.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private double coutTotal;
    private Boolean estPayee = false;
    private Boolean estTreminee = false;
    private LocalDate dateDebutReservation;
    private LocalDate dateFinReservation ;

    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @ManyToOne
    private Chambre chambre;

    @ManyToOne
    private Client client;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Reclamation> reclamations = new ArrayList<>();

}
