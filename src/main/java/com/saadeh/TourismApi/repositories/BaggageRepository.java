package com.saadeh.TourismApi.repositories;

import com.saadeh.TourismApi.entities.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage,Long> {
}
