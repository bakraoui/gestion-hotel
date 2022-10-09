package com.example.demo.reclamation;

import com.example.demo.reclamation.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepo  extends JpaRepository<Reclamation, Long> {
}
