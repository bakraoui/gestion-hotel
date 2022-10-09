package com.example.demo.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.create(client),HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Client> update(@RequestBody Client client){
        return new ResponseEntity<>(clientService.update(client),HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<Client> delete(@RequestBody Client client){
        clientService.delete(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Client>> getAll(){
        List<Client> clients = clientService.getAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id){
        Client client = clientService.getById(id);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @GetMapping("/username/{id}")
    public ResponseEntity<Client> getByUsername(@PathVariable String username){
        Client client = clientService.getByUsername(username);
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }
}
