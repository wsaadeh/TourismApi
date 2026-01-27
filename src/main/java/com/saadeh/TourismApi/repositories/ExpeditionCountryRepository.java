package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.ExpeditionCountry;
import com.saadeh.TourismApi.entities.ExpeditionCountryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionCountryRepository extends JpaRepository<ExpeditionCountry, ExpeditionCountryPK> {
}
