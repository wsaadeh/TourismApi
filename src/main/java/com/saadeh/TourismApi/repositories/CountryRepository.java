package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("""
            SELECT obj
            FROM Country obj
            JOIN FETCH obj.countryContinent
            WHERE LOWER(obj.name) like LOWER(CONCAT('%',:countryName,'%'))
            AND (obj.countryContinent.id = 0 OR obj.countryContinent.id = :continent)
            """)
    Page<Country> searchAllPaged(String countryName, Long continent, Pageable pageable);
}
