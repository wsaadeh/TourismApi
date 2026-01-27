package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels,Long> {
}
