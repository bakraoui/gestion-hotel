package com.example.demo.intervention;

import com.example.demo.intervention.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionRepo  extends JpaRepository<Intervention, Long> {
}
