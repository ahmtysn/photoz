package com.karadag.photoz.repository;

import com.karadag.photoz.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {

}
