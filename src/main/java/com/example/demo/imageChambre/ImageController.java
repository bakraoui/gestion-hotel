package com.example.demo.imageChambre;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/images/")
public class ImageController {

    @Autowired
    private final ImageService service;

    @PostMapping("/{id}")
    public ResponseEntity<ImageChambre> add(@RequestParam("file") MultipartFile file, @PathVariable Long id){
        ImageChambre image = service.add(file,id);

        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
