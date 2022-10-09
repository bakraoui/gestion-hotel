package com.example.demo.intervention;

import com.example.demo.reclamation.Reclamation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemandeIntervention {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String description;
    private Boolean estTraitee;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @OneToOne
    private Reclamation reclamation;

    @OneToOne
    private Intervention intervention;

}
