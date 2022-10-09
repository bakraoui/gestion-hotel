package com.example.demo.technicien;

import com.example.demo.technicien.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicienRepo extends JpaRepository<Technicien, Long> {
    Technicien findByUsername(String username);
}
