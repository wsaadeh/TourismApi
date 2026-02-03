package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.HotelsDto;
import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.Hotels;
import com.saadeh.TourismApi.repositories.CountryRepository;
import com.saadeh.TourismApi.repositories.HotelsRepository;
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
public class HotelsService {

    @Autowired
    private HotelsRepository repository;

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public Page<HotelsDto> findAll(Pageable pageable){
        Page<Hotels> result = repository.findAll(pageable);
        return result.map(HotelsDto::new);
    }

    @Transactional(readOnly = true)
    public HotelsDto findById(Long id){
        Hotels result = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Entity not found."));
        return new HotelsDto(result);
    }

    @Transactional
    public HotelsDto insert(HotelsDto dto){
        Hotels entity = new Hotels();
        CopyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new HotelsDto(entity);
    }

    @Transactional
    public HotelsDto update(Long id, HotelsDto dto){
        try {
            Hotels entity = repository.getReferenceById(id);
            CopyDtoToEntity(dto,entity);
            entity = repository.save(entity);
            return new HotelsDto(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Id not found " + id);
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }

    private void CopyDtoToEntity(HotelsDto dto, Hotels entity) {
        entity.setName(dto.getName());
        entity.setMealPlan(dto.getMealPlan());
        entity.setApartmentType(dto.getApartmentType());
        entity.setCategory(dto.getCategory());
        entity.setJoker(dto.isJoker());
        entity.setOk(dto.isOk());
        entity.setAddress(dto.getAddress());
        entity.setDdi(dto.getDdi());
        entity.setDdd(dto.getDdd());
        entity.setTelephone(dto.getTelephone());
        entity.setFax(dto.getFax());
        entity.setEmail(dto.getEmail());
        entity.setWebsite(dto.getWebsite());
        entity.setCity(dto.getCity());
        entity.setPhoto1(dto.getPhoto1());
        entity.setPhoto2(dto.getPhoto2());
        entity.setPhoto3(dto.getPhoto3());
        Country c = countryRepository.findById(dto.getCountry().getId()).orElseThrow(()->new ResourceNotFoundException("Country not found id " + dto.getCountry().getId()));
        if (!c.equals(null)){
            dto.setCountry(c);
        }
        entity.setCountry(dto.getCountry());
    }

}
