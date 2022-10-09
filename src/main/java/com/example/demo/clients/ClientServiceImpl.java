package com.example.demo.clients;


import com.example.demo.exceptions.ObjectNotFoundException;
import com.example.demo.exceptions.InvalideData;
import com.example.demo.exceptions.ObjectAlreadyExistException;

import static com.example.demo.clients.ClientRegistrationValidator.*;
import static com.example.demo.clients.ClientRegistrationValidator.ResultValidation.SUCCESS;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public  Client create(Client client) {

        ResultValidation resultValidation = isSomeFieldsEmpty()
                .and(isUsernameValid())
                .and(isPhoneValid())
                .apply(client);

        // if all test pass
        if (resultValidation.equals(SUCCESS)){

            // check if  user already exist with that username
            String username = client.getUser().getUsername();
            String password = client.getUser().getPassword();
            boolean is_exist = clientRepo.findByUserUsername(username).isEmpty();

            if (!is_exist){
                throw new ObjectAlreadyExistException("ce nom d'utilisateur deja existe");
            } else {
                // hash password
                client.getUser().setPassword(passwordEncoder.encode(password));
                return clientRepo.save(client);
            }

        }else {
            String exception = resultValidation.name();
            throw new InvalideData(exception);
        }

    }

    @Override
    public Client update(Client client) {

        ResultValidation resultValidation = isSomeFieldsEmpty()
                .and(isUsernameValid())
                .and(isPhoneValid())
                .apply(client);

        // if all test pass
        if (resultValidation.equals(SUCCESS)){
            return clientRepo.save(client);
        }else {
            throw new InvalideData(resultValidation.name());
        }
    }

    @Override
    public void delete(Client client) {
        clientRepo.delete(client);
    }

    @Override
    public List<Client> getAll() {

        return clientRepo.findAll();

    }

    @Override
    public Client getById(Long id) {

        return clientRepo.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(String.format("Aucun client trouvee avec id = %d ", id))
        );

    }

    @Override
    public Client getByUsername(String username) {
        Optional<Client> client = clientRepo.findByUserUsername(username);

        if (client.isPresent()) return client.stream().findFirst().orElse(null);

        else throw new RuntimeException(
                String.format("Pas d'utilisateur avec username : %s", username)
        );

    }



}
