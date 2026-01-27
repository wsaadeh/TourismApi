package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends JpaRepository<Photos,Long> {
}
