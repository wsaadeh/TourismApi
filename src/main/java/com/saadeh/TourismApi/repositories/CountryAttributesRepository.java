package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.CountryAttributes;
import com.saadeh.TourismApi.entities.CountryAttributesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryAttributesRepository extends JpaRepository<CountryAttributes, CountryAttributesPK> {
}
