package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.MapsDto;
import com.saadeh.TourismApi.entities.Expedition;
import com.saadeh.TourismApi.entities.Maps;
import com.saadeh.TourismApi.repositories.ExpeditionRepository;
import com.saadeh.TourismApi.repositories.MapsRepository;
import com.saadeh.TourismApi.services.exceptions.DatabaseException;
import com.saadeh.TourismApi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MapsService {

    @Autowired
    private MapsRepository repository;

    @Autowired
    private ExpeditionRepository expeditionRepository;

    @Transactional(readOnly = true)
    public Page<MapsDto> findAll(Pageable pageable){
        return repository.findAll(pageable).map(MapsDto::new);
    }

    @Transactional(readOnly = true)
    public MapsDto findById(Long id){
        Maps result = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found " + id));
        return new MapsDto(result);
    }

    @Transactional
    public MapsDto insert(MapsDto dto){
        try {
            Maps entity = new Maps();
            copyDtoToEntity(dto,entity);
            entity = repository.save(entity);
            return new MapsDto(entity);
        }catch (NonUniqueObjectException e){
            throw new DatabaseException("Duplicate Key Exception.");
        }catch (DuplicateKeyException e){
            throw new DatabaseException("Duplicate key exception");
        }
    }

    @Transactional
    public MapsDto update(Long id,MapsDto dto){
        try {
            Maps entity = repository.getReferenceById(id);
            copyDtoToEntity(dto,entity);
            entity = repository.save(entity);
            return new MapsDto(entity);
        }catch (EntityNotFoundException e){
            throw new DatabaseException("Id not found " + id);
        }
    }

    @Transactional
    public void  delete(Long id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Id not found " + id);
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }


    private void copyDtoToEntity(MapsDto dto, Maps entity) {
        entity.setMap1(dto.getMap1());
        entity.setMap2(dto.getMap2());
        entity.setMap3(dto.getMap3());
        entity.setMap4(dto.getMap4());
        entity.setMap1Txt(dto.getMap1Txt());
        entity.setMap2Txt(dto.getMap2Txt());
        entity.setMap3Txt(dto.getMap3Txt());
        entity.setMap4Txt(dto.getMap4Txt());
        Expedition expedition = expeditionRepository.findById(dto.getExpeditionId()).orElseThrow(()->new ResourceNotFoundException("Expedition not found id " + dto.getExpeditionId()));
        entity.setExpedition(expedition);
    }


}
