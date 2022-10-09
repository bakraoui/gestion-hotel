package com.example.demo.intervention;

import com.example.demo.intervention.DemandeIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeInterventionRepo extends JpaRepository<DemandeIntervention, Long> {
}
