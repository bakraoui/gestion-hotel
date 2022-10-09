package com.example.demo.chambre;

import com.example.demo.chambre.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChambreRepo  extends JpaRepository<Chambre, Long> {
    Optional<Chambre> findByNumero(String numero);
}
