package com.example.demo.configuration.security.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class AppUser {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String username;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Role> roles = new ArrayList<>();


}
