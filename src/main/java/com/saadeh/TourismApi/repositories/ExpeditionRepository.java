package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpeditionRepository extends JpaRepository<Expedition,Long> {
}
