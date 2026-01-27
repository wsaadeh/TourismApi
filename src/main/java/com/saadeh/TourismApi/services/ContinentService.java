package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.ContinentDto;
import com.saadeh.TourismApi.entities.Continent;
import com.saadeh.TourismApi.repositories.ContinentRepository;
import com.saadeh.TourismApi.services.exceptions.DatabaseException;
import com.saadeh.TourismApi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository repository;

    @Transactional(readOnly = true)
    public ContinentDto findById(Long id){
        Continent continent = repository.findById(id).get();
        return new ContinentDto(continent);
    }

    @Transactional(readOnly = true)
    public List<ContinentDto> findAll(){
        List<Continent> continentList = repository.findAll();
        return continentList.stream().map(x-> new ContinentDto(x)).toList();
    }

    @Transactional
    public ContinentDto insert(ContinentDto continentDto){
        Continent continent = new Continent();
        copyDtoToEntity(continentDto, continent);
        continent = repository.save(continent);
        return new ContinentDto(continent);
    }

    @Transactional
    public ContinentDto update(Long id, ContinentDto dto) {
        try {
            Continent entity = repository.getReferenceById(id);
            copyDtoToEntity(dto,entity);
            entity = repository.save(entity);
            return new ContinentDto(entity);
        }
        catch (HttpMessageConversionException e){
            throw new ResourceNotFoundException("Resource not found.");
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found.");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e ){
            throw new DatabaseException("Data integrity violation.");
        }
    }

    private void copyDtoToEntity(ContinentDto continentDto, Continent continent) {
        continent.setName(continentDto.getName());
        continent.setLanguage(continentDto.getLanguage());
    }

}
