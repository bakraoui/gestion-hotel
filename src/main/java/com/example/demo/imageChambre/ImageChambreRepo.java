package com.example.demo.imageChambre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageChambreRepo  extends JpaRepository<ImageChambre, Long> {
}
