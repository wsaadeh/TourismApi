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
            AND obj.countryContinent.id = :continent
            """)
    Page<Country> searchAllPaged(String countryName, Long continent, Pageable pageable);


    @Query("""
            SELECT obj
            FROM Country obj
            JOIN FETCH obj.countryContinent
            WHERE LOWER(obj.name) like LOWER(CONCAT('%',:countryName,'%'))            
            """)
    Page<Country> searchByName(String countryName,Pageable pageable);

    @Query(nativeQuery = true,value = """
            SELECT p.* FROM tb_country as p
            INNER JOIN tb_continent as c
            ON p.continent_id = c.id
            WHERE LOWER(p.name) like LOWER(CONCAT('%', :countryName, '%'))
            AND (:continent IS NULL OR p.continent_id = :continent)
            """, countQuery = """
            SELECT COUNT(*) FROM (            
            SELECT p.* FROM tb_country as p
            INNER JOIN tb_continent as c
            ON p.continent_id = c.id
            WHERE LOWER(p.name) like LOWER(CONCAT('%', :countryName, '%'))
            AND (:continent IS NULL OR p.continent_id = :continent)) AS tb_result
            """)
    Page<Country> searchAllPagedNative(String countryName, Long continent, Pageable pageable);
}
