package com.example.demo.etage;

import com.example.demo.bloc.Bloc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etage {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String numero;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @ManyToOne
    private Bloc bloc;
}
