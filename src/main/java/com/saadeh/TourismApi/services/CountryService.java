package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.CountryDto;
import com.saadeh.TourismApi.dto.CountryMinDto;
import com.saadeh.TourismApi.entities.Continent;
import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.repositories.ContinentRepository;
import com.saadeh.TourismApi.repositories.CountryRepository;
import com.saadeh.TourismApi.services.exceptions.DatabaseException;
import com.saadeh.TourismApi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {

    @Autowired
    CountryRepository repository;

    @Autowired
    ContinentRepository continentRepository;

    @Transactional(readOnly = true)
    public Page<CountryDto> searchAllPaged(String countryName, Long continentID, Pageable pageable ){
        Page<Country> result = repository.searchAllPaged(countryName,continentID,pageable);
        return result.map(x->new CountryDto(x));
    }

    @Transactional(readOnly = true)
    public CountryDto findById(Long id) {
        return repository.findById(id)
                .stream()
                .map(c->new CountryDto(c))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Entity not found."));
    }

    @Transactional
    public CountryDto insert(CountryDto dto){
        Country entity = new Country();
        copyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new CountryDto(entity);
    }

    @Transactional
    public CountryDto update(Long id,CountryDto dto){
        try {
            Country entity = repository.getReferenceById(id);
            copyDtoToEntity(dto,entity);
            repository.save(entity);
            return new CountryDto(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(CountryDto dto, Country entity) {
        entity.setName(dto.getName());
        entity.setContinent(dto.getContinent());
        entity.setLanguage(dto.getLanguage());
    }


    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Id not found " + id);
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }
}
