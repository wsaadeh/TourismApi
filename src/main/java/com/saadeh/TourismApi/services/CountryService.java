package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.CountryDto;
import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {

    @Autowired
    CountryRepository repository;

    @Transactional(readOnly = true)
    public Page<CountryDto> searchAllPaged(String countryName, Long continentID, Pageable pageable ){
        Page<Country> result = repository.searchAllPaged(countryName,pageable);
        //Page<Country> result = repository.findAll(pageable);
        return result.map(x->new CountryDto(x));
    }

}
