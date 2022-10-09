package com.example.demo.chambre;

import com.example.demo.etage.Etage;
import com.example.demo.imageChambre.ImageChambre;
import com.example.demo.reservation.Reservation;
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
public class Chambre {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String numero;
    private Double largeur;
    private Double longueur;
    private String couleur;
    private int nombreFenetre;
    private Double prix;
    private Boolean estReservee;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<ImageChambre> images = new ArrayList<>();

    @ManyToOne
    private Etage etage;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Reservation> reservations = new ArrayList<>();
}
