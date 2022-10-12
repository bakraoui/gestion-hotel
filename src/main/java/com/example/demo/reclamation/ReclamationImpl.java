package com.example.demo.reclamation;

import com.example.demo.exceptions.InvalideData;
import com.example.demo.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.reclamation.ReclamationCreatorValidator.*;
import static com.example.demo.reclamation.ReclamationCreatorValidator.Validation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReclamationImpl implements ReclamationService{

    @Autowired
    private final ReclamationRepo repo;

    @Override
    public Reclamation create(Reclamation reclamation) {
        Validation result = isClientExit()
                .and(isDescriptionEmpty())
                .and(isReservationExist())
                .apply(reclamation);

        if (!result.equals(SUCCESS)){
            throw new InvalideData(result.name());
        }
        return repo.save(reclamation);
    }

    @Override
    public Reclamation update(Long id, Reclamation reclamation) {
        reclamation.setId(id);
        return repo.save(reclamation);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Reclamation> getAll() {
        return repo.findAll();
    }

    @Override
    public Reclamation getById(Long id) {
        Optional<Reclamation> reclamation = repo.findById(id);

        if (!reclamation.isPresent()) {
            String message = "aucune reclamation n'exite avec id = " + id;
            throw new ObjectNotFoundException(message);
        }

        return reclamation.get();
    }
}
