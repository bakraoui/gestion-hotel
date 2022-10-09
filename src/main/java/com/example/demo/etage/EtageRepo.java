package com.example.demo.etage;

import com.example.demo.etage.Etage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtageRepo  extends JpaRepository<Etage, Long> {
}
