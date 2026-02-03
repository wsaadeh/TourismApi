package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.EventDto;
import com.saadeh.TourismApi.entities.Country;
import com.saadeh.TourismApi.entities.Event;
import com.saadeh.TourismApi.repositories.CountryRepository;
import com.saadeh.TourismApi.repositories.EventRepository;
import com.saadeh.TourismApi.services.exceptions.DatabaseException;
import com.saadeh.TourismApi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public Page<EventDto> findAll(Pageable pageable) {
        Page<Event> result = repository.findAll(pageable);
        return result.map(EventDto::new);
    }

    @Transactional(readOnly = true)
    public EventDto findById(Long id) {
        return repository.findById(id)
                .stream()
                .map(EventDto::new)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    }

    @Transactional
    public EventDto insert(EventDto dto){
        Event entity = new Event();
        copyDtoToEntity(dto,entity);
        entity = repository.save(entity);
        return new EventDto(entity);
    }

    @Transactional
    public EventDto update(Long id,EventDto dto){
        try {
            Event entity = repository.getReferenceById(id);
            copyDtoToEntity(dto,entity);
            entity = repository.save(entity);
            return new EventDto(entity);
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

    private void copyDtoToEntity(EventDto dto, Event entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setJoker(dto.isJoker());
        entity.setOk(dto.isOk());
        Country c = countryRepository.findById(dto.getCountry().getId()).get();
        if (!c.equals(null)) {
            dto.setCountry(c);
        }
        entity.setCountry(dto.getCountry());
    }
}
