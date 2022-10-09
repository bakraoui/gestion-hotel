package com.example.demo.intervention;

import com.example.demo.technicien.Technicien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @OneToOne
    private DemandeIntervention demandeIntervention;

    @ManyToOne
    private Technicien technicien;
}
