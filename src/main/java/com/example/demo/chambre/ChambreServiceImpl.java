package com.example.demo.chambre;

import com.example.demo.exceptions.IdNullException;
import com.example.demo.exceptions.ObjectAlreadyExistException;
import com.example.demo.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private final ChambreRepo repo;

    @Override
    public Chambre create(Chambre chambre) {
        String numero = chambre.getNumero();
        Optional<Chambre> optional = repo.findByNumero(numero);
        if (optional.isPresent()) {
            String message = "chambre deja existe avec le numero : ";
            throw new ObjectAlreadyExistException(message + numero);
        }
        repo.save(chambre);

        return chambre;
    }

    @Override
    public Chambre update(Long id, Chambre chambre)  {

        if (id == null) {
            throw new IdNullException("id non reconnu.");
        }
        repo.save(chambre);
        return chambre;
    }

    @Override
    public void delete(Chambre chambre) {
        repo.delete(chambre);
    }

    @Override
    public List<Chambre> getAll() {
        return repo.findAll();
    }

    @Override
    public Chambre getById(Long id) {
        Optional<Chambre> chambre = repo.findById(id);

        if (chambre.isPresent()) return chambre.get();
        else {
            String message = "aucun chambre trouvee avec id = ";
            throw new ObjectNotFoundException(message + id);
        }

    }

    @Override
    public Chambre getByNumero(String numero) {
        Optional<Chambre> chambre = repo.findByNumero(numero);

        if (chambre.isPresent()) return chambre.get();
        else {
            String message = "aucune chambre trouvee avec numero = ";
            throw new ObjectNotFoundException(message + numero);
        }

    }
}
