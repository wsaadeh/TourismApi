package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
