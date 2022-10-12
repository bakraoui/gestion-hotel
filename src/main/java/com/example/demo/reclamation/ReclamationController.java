package com.example.demo.reclamation;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reclamation")
public class ReclamationController {

    @Autowired
    private final ReclamationService service;

    @PostMapping()
    public ResponseEntity<Reclamation> save(@RequestBody Reclamation reclamation){
        return new ResponseEntity<>(service.create(reclamation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reclamation> update(@PathVariable Long id,@RequestBody Reclamation reclamation){
        return new ResponseEntity<>(service.update(id,reclamation), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reclamation>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamation> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return new ResponseEntity<>("la reclamation "+id+" est supprimee",HttpStatus.OK);
    }

}
