package com.example.demo.imageChambre;

import com.example.demo.chambre.Chambre;
import com.example.demo.chambre.ChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageImpl implements ImageService {

    @Autowired
    private final ImageChambreRepo imageRepo;

    @Autowired
    private final ChambreService chambreService;

    @Override
    public ImageChambre add(MultipartFile file, Long id) {
        ImageChambre image = new ImageChambre();
        Chambre chambre = chambreService.getById(id);
        String fileName = file.getOriginalFilename();
        try {
            byte[] bytes = file.getBytes();
            image.setDonnees(bytes);
            image.setChambre(chambre);
            image.setNom(fileName);

//            return imageRepo.save(image);

            return image;
        }catch (IOException e) {
            throw new RuntimeException("");
        }

    }

    @Override
    public List<ImageChambre> addAll(List<ImageChambre> images) {
        return images;
    }

    @Override
    public void delete(Long id) {
        imageRepo.deleteById(id);
    }
}
