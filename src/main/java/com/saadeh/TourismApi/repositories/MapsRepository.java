package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Maps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapsRepository extends JpaRepository<Maps,Long> {
}
