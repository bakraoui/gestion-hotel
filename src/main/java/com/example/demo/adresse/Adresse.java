package com.example.demo.adresse;

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
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String pay;
    private String ville;
    private String rue;
    private LocalDate dateCreation = LocalDate.now();
    private LocalDate dateModification = LocalDate.now();

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Client> clients = new ArrayList<>();
}
