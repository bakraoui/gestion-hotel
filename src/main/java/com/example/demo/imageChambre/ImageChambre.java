package com.example.demo.imageChambre;


import com.example.demo.chambre.Chambre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageChambre {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    private String url;
    @Lob
    private byte[] donnees;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @ManyToOne
    private Chambre chambre;

}
