package com.karadag.photoz.web;

import com.karadag.photoz.model.Photo;
import com.karadag.photoz.service.PhotozService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotozController {

    private final PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photozService.get(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id) {
        Photo photo = photozService.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        photozService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

}
