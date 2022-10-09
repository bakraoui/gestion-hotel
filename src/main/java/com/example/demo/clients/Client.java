package com.example.demo.clients;

import com.example.demo.adresse.Adresse;
import com.example.demo.reclamation.Reclamation;
import com.example.demo.reservation.Reservation;
import com.example.demo.configuration.security.beans.AppUser;
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

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    private String prenom;
    private String cin;

    private String telephone;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private AppUser user;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne
    private Adresse adresse;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Reclamation> reclamations = new ArrayList<>();

}
