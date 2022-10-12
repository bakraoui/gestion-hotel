package com.example.demo.reclamation;


import com.example.demo.clients.Client;

import java.util.List;

public interface ReclamationService {

    Reclamation create(Reclamation reclamation);
    Reclamation update(Long id, Reclamation reclamation);
    void delete(Long id);
    List<Reclamation> getAll();
    Reclamation getById(Long id);
}
