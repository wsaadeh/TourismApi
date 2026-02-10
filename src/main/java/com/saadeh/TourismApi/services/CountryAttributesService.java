package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.CountryAttributesDto;
import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.CountryAttributes;
import com.saadeh.TourismApi.entities.CountryAttributesPK;
import com.saadeh.TourismApi.entities.CountryEnum;
import com.saadeh.TourismApi.repositories.CountryAttributesRepository;
import com.saadeh.TourismApi.services.exceptions.DatabaseException;
import com.saadeh.TourismApi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryAttributesService {

    @Autowired
    private CountryAttributesRepository repository;

    @Transactional(readOnly = true)
    public Page<CountryAttributesDto> findAll(Pageable pageable){
        Page<CountryAttributes> result = repository.findAll(pageable);
        return result.map(CountryAttributesDto::new);
    }

    @Transactional(readOnly = true)
    public CountryAttributesDto findById(CountryAttributesPK id){
        CountryAttributes result = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
        return new CountryAttributesDto(result);
    }

    @Transactional
    public CountryAttributesDto insert(CountryAttributesDto dto){
        CountryAttributes entity = new CountryAttributes();
        CopyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new CountryAttributesDto(entity);
    }

    @Transactional
    public CountryAttributesDto update(long countryId,String attribute, CountryAttributesDto dto){
        CountryAttributesPK id = new CountryAttributesPK(countryId, CountryEnum.valueOf(attribute));

        try {
            CountryAttributes entity = repository.getReferenceById(id);
            dto.setCountry(entity.getCountry());
            dto.setAttribute(entity.getAttribute());
            CopyDtoToEntity(dto,entity);
            entity = repository.save(entity);
            return new CountryAttributesDto(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + countryId);
        }

    }

    @Transactional
    public void delete(Long countryId, String attribute){
        CountryAttributesPK id = new CountryAttributesPK(countryId, CountryEnum.valueOf(attribute));
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Country " + countryId + " attribute " + attribute + "not found.");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }

    }

    private void CopyDtoToEntity(CountryAttributesDto dto, CountryAttributes entity) {
        entity.setCountry(dto.getCountry());
        entity.setAttribute(dto.getAttribute());
        entity.setDescription(dto.getDescription());
    }
}
