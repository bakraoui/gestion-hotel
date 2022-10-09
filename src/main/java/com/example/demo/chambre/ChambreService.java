package com.example.demo.chambre;

import com.example.demo.exceptions.IdNullException;

import java.util.List;

public interface ChambreService {

    Chambre create(Chambre chambre);
    Chambre update(Long id, Chambre chambre) throws IdNullException;
    void delete(Chambre client);
    List<Chambre> getAll();
    Chambre getById(Long id);
    Chambre getByNumero(String numero);
}
