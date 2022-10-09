package com.example.demo.clients;

import com.example.demo.clients.Client;

import java.util.List;

public interface ClientService {

    Client create(Client client);
    Client update(Client client);
    void delete(Client client);
    List<Client> getAll();
    Client getById(Long id);
    Client getByUsername(String username);
}
