package com.example.demo.clients;

import com.example.demo.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo  extends JpaRepository<Client, Long> {
    Optional<Client> findByUserUsername(String username);
}
