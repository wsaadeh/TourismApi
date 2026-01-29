package com.saadeh.TourismApi.services;

import com.saadeh.TourismApi.dto.EventDto;
import com.saadeh.TourismApi.entities.Event;
import com.saadeh.TourismApi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Transactional(readOnly = true)
    public Page<EventDto> findAll(Pageable pageable){
        Page<Event> result = repository.findAll(pageable);
        return result.map(EventDto::new);
    }

    @Transactional(readOnly = true)
    public EventDto findById(Long id){
        Event result = repository.findById(id).get();
        return new EventDto(result);
    }
}
