package com.example.demo.bloc;

import com.example.demo.etage.Etage;
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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String numero;
    private int nombreFacades;
    private int nombreEtages;
    private int nombreChambres;

    private LocalDate dateConstruction;
    private LocalDate dateMiseEnService;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<ImageBloc> images = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Etage> etages = new ArrayList<>();
}
