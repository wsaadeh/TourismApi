package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
