package com.example.demo.imageChambre;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    ImageChambre add(MultipartFile image, Long id);
    List<ImageChambre> addAll(List<ImageChambre> images);
    void delete(Long id);

}
