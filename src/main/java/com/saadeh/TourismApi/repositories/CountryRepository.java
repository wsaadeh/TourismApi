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
            WHERE LOWER(obj.name) like LOWER(CONCAT('%',:countryName,'%'))           
            """)
    Page<Country> searchAllPaged(String countryName, Pageable pageable);
}
