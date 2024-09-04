package com.karadag.photoz.service;

import com.karadag.photoz.model.Photo;
import com.karadag.photoz.repository.PhotozRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@Service
public class PhotozService {
//    final Map<String, Photo> db = new HashMap<>() {{
//        put("1", new Photo("1","hello.jpg"));
//    }};

    private final PhotozRepository photozRepository;

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);

        photozRepository.save(photo);

        return photo;
    }
}
