package com.controller;

import com.model.Image;
import com.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable int id) {
        return imageRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Image createImage(@RequestBody Image image) {
        return imageRepository.save(image);
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable int id, @RequestBody Image image) {
        if (imageRepository.existsById(id)) {
            image.setImageID(id);
            return imageRepository.save(image);
        } else {
            return null; // Or handle as needed
        }
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable int id) {
        imageRepository.deleteById(id);
    }
}
