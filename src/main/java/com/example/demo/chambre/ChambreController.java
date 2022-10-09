package com.example.demo.chambre;

import com.example.demo.chambre.Chambre;
import com.example.demo.chambre.ChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chambre")
public class ChambreController {

    private final ChambreService chambreService;

    @PostMapping("")
    public ResponseEntity<Chambre> create(@RequestBody Chambre chambre){
        return new ResponseEntity<>(
                chambreService.create(chambre),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> update(@PathVariable Long id,@RequestBody Chambre chambre){
        return new ResponseEntity<>(
                chambreService.update(id,chambre),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("")
    public ResponseEntity<Chambre> delete(@RequestBody Chambre chambre){
        chambreService.delete(chambre);
        return new ResponseEntity<>(
                chambre,
                HttpStatus.CREATED
        );
    }

    @GetMapping("")
    public ResponseEntity<List<Chambre>> getAll(){
        return new ResponseEntity<>(
                chambreService.getAll(),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getById(@PathVariable Long id){
        return new ResponseEntity<>(
                chambreService.getById(id),
                HttpStatus.FOUND
        );
    }

    @GetMapping("/numero={numero}")
    public ResponseEntity<Chambre> getByNumero(@Param("numero") String numero){
        return new ResponseEntity<>(
                chambreService.getByNumero(numero),
                HttpStatus.FOUND
        );
    }





}
